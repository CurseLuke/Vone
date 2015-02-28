package com.kieronwiltshire.vone.arena;

import com.kieronwiltshire.vone.arena.exceptions.IncompatibleArenaSessionException;
import org.bukkit.event.Listener;

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
public interface Session extends Listener {

    /**
     * This method initiates a session
     */
    public void init() throws IncompatibleArenaSessionException;

    /**
     * This method would be executed each session update
     */
    public void run();

    /**
     * This method destroys a session
     */
    public void destroy();

}