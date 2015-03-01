package com.kieronwiltshire.vone.main.arenas;

import com.kieronwiltshire.vone.main.BasicArena;
import org.bukkit.Location;

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
public class CageArena extends BasicArena {

    // Instance variables
    private Location attackerSpawn;
    private Location defenderSpawn;

    /**
     * Arena constructor
     *
     * @param name          The name of the arena
     * @param version       The version of the arena
     * @param authors       The authors of the arena
     * @param description   The description of the arena
     * @param download      The download link for the arena
     * @param spawn         The spawn location of the arena
     * @param attackerSpawn The spawn for player 1
     * @param defenderSpawn The spawn for player 2
     */
    public CageArena(String name, String version, String[] authors, String[] description, String download, Location spawn, Location attackerSpawn, Location defenderSpawn) {
        super(name, version, authors, description, download, spawn);

        this.attackerSpawn = attackerSpawn;
        this.defenderSpawn = defenderSpawn;
    }

    /**
     * Set the attacker spawn
     *
     * @param attackerSpawn Location object
     */
    public void setAttackerSpawn(Location attackerSpawn) {
        this.attackerSpawn = attackerSpawn;
    }

    /**
     * Get the attacker spawn
     *
     * @return Location object
     */
    public Location getAttackerSpawn() {
        return this.attackerSpawn;
    }

    /**
     * Set the defender spawn
     * @param defenderSpawn Location object
     */
    public void setDefenderSpawn(Location defenderSpawn) {
        this.defenderSpawn = defenderSpawn;
    }

    /**
     * Get the defender spawn
     *
     * @return Location object
     */
    public Location getDefenderSpawn() {
        return this.defenderSpawn;
    }

    @Override
    public void save() {
        super.save();

        // TODO save to config
    }

}
