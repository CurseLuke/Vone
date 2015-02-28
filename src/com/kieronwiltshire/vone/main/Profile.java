package com.kieronwiltshire.vone.main;

import org.bukkit.entity.Player;

import javax.annotation.Nullable;

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
public class Profile {

    // Instance variables
    private Player player;

    private Kit kit;

    /**
     * Profile constructor
     *
     * @param player The Player you wish to create the Profile for
     */
    public Profile(Player player) {
        this.player = player;
    }

    /**
     * Get the Player of the Profile
     *
     * @return Player object
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Get the Kit of the Profile
     *
     * @return Kit object
     */
    @Nullable
    public Kit getKit() { return this.kit; }

    /**
     * Set the Kit of the Profile
     * @param kit Kit object
     */
    public void setKit(Kit kit) {
        this.kit = kit;
    }

}
