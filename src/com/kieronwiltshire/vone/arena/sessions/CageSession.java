package com.kieronwiltshire.vone.arena.sessions;

import com.kieronwiltshire.vone.arena.Session;
import com.kieronwiltshire.vone.arena.arenas.CageArena;
import com.kieronwiltshire.vone.arena.exceptions.IncompatibleArenaSessionException;
import com.kieronwiltshire.vone.main.Game;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @name Vone
 * @version 1.0
 * @author Kieron Wiltshire
 * @contact kieron.wiltshire@outlook.com
 * @copyright (c) Kieron Wiltshire 2015
 *
 * @description
 *  Vone is a 1v1, 2v2, 3v3 and Free For All (FFA) modification/plugin/extension
 *  built on top of the Bukkit and Spigot API.
 */
public class CageSession implements Session {

    /**
     * Stage enumerator
     */
    public enum Stage {
        LOADING,
        PLAYING;
    }

    // Instance variables
    private Player attacker;
    private Player defender;
    private Player winner;

    private int attackerScore;
    private int defenderScore;

    private int time;
    private int rounds;

    private int currentTime;
    private int currentRound;

    private boolean swap;

    private Stage stage;
    private CageArena arena;

    /**
     * CageSession constructor
     *
     * @param attacker The attacking player's unique identifier
     * @param defender The defending player's unique identifier
     * @param time The amount of time to pass per round
     * @param rounds The number of rounds to play
     */
    public CageSession(Player attacker, Player defender, int time, int rounds) {
        this.attacker = attacker;
        this.defender = defender;
        this.time = time;
        if (rounds % 2 == 0) {
            rounds = rounds - 1;
        }
        this.rounds = rounds;
        this.setStage(Stage.LOADING);
    }

    /**
     * Get the player who is attacking
     *
     * @return Player object
     */
    public Player getAttacker() {
        return this.attacker;
    }

    /**
     * Get the player who is defending
     *
     * @return Player object
     */
    public Player getDefender() {
        return this.defender;
    }

    /**
     * Get the amount of time to be played per round in seconds
     *
     * @return Integer value
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Get the total amount of rounds to be played
     *
     * @return Integer value
     */
    public int getRounds() {
        return this.rounds;
    }

    /**
     * Get the current time of the session in seconds
     *
     * @return Integer value
     */
    public int getCurrentTime() {
        return this.currentTime;
    }

    /**
     * Get the current number of rounds played
     *
     * @return Integer value
     */
    public int getCurrentRound() {
        return this.rounds;
    }

    /**
     * Set the score of the attacker
     *
     * @param score Integer value
     */
    public void setAttackerScore(int score) {
        this.attackerScore = score;
    }

    /**
     * Get the score of the attacker
     *
     * @return Integer value
     */
    public int getAttackerScore() {
        return this.attackerScore;
    }

    /**
     * Set the score of the defender
     *
     * @param score Integer value
     */
    public void setDefenderScore(int score) {
        this.defenderScore = score;
    }

    /**
     * Get the score of the defender
     *
     * @return Integer value
     */
    public int getDefenderScore() {
        return this.defenderScore;
    }

    /**
     * Set the stage of the Session
     *
     * @param stage Stage enumerator value
     */
    public void setStage(Stage stage) {
        if (stage == Stage.LOADING) {
            this.setup();
        }
        if (stage == Stage.PLAYING) {
            this.currentTime = this.time;
        }
        this.stage = stage;
    }

    /**
     * Get the stage of the Session
     *
     * @return Stage enumerator value
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Setup the round
     */
    private void setup() {
        this.swap = !this.swap;

        Location attSpawn = this.arena.getAttackerSpawn();
        Location defSpawn = this.arena.getDefenderSpawn();

        if (this.swap) {
            attSpawn = this.arena.getDefenderSpawn();
            defSpawn = this.arena.getAttackerSpawn();
        }

        this.attacker.teleport(attSpawn);
        this.defender.teleport(defSpawn);

        this.preparePlayer(this.attacker);
        this.preparePlayer(this.defender);

        this.currentRound++;
        this.currentTime = 5;
    }

    /**
     * Prepare the player for the round
     *
     * @param player Player object
     */
    private void preparePlayer(Player player) {
        // TODO heal player, give weapons, etc...
    }

    @Override
    public void init() throws IncompatibleArenaSessionException {
        if (this.arena == null) {
            Game game = Game.getInstance();
            if (game.getArena(this) instanceof CageArena) {
                this.arena = (CageArena) game.getArena(this);
            } else {
                throw new IncompatibleArenaSessionException(game.getArena(this), this);
            }
        }
    }

    @Override
    public void run() {
        if (this.currentRound > this.rounds) {
            this.destroy();
        } else {
            if (this.stage == Stage.LOADING) {
                if (this.currentTime > 0) {
                    this.currentTime--;
                } else {
                    this.setStage(Stage.PLAYING);
                }
            }
            if (this.stage == Stage.PLAYING) {
                if (this.currentTime > 0) {
                    this.currentTime--;
                } else {
                    this.setStage(Stage.LOADING);
                }
            }
        }
    }

    @Override
    public void destroy() {
        Game.getInstance().setSession(this.arena, null);

        // TODO save stats etc..
    }

    @EventHandler
    private void onDeath(PlayerDeathEvent event) {
        if (event.getEntity() == this.attacker) {
            this.setDefenderScore(this.getDefenderScore() + 1);
            this.setStage(Stage.LOADING);
        }
        else if (event.getEntity() == this.defender) {
            this.setAttackerScore(this.getAttackerScore() + 1);
            this.setStage(Stage.LOADING);
        }
    }

    @EventHandler
    private void onMove(PlayerMoveEvent event) {
        if ((event.getPlayer() == this.attacker) || (event.getPlayer() == this.defender)) {
            if (this.getStage() == Stage.LOADING) {
                event.getPlayer().teleport(event.getPlayer().getLocation());
            }
        }
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event) {
        if ((event.getPlayer() == this.attacker) || (event.getPlayer() == this.defender)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event) {
        if ((event.getPlayer() == this.attacker) || (event.getPlayer() == this.defender)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        if ((event.getPlayer() == this.attacker) || (event.getPlayer() == this.defender)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        if ((event.getPlayer() == this.attacker) || (event.getPlayer() == this.defender)) {
            if (this.attacker.isOnline()) {
                this.winner = this.attacker;
            } else {
                this.winner = this.defender;
            }
            this.destroy();
        }
    }

}