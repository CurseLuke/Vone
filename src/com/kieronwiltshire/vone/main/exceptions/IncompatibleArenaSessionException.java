package com.kieronwiltshire.vone.main.exceptions;

import com.kieronwiltshire.vone.main.Arena;
import com.kieronwiltshire.vone.main.Session;

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
public class IncompatibleArenaSessionException extends Exception {

    /**
     * Throw an IncompatibleArenaSessionException error
     *
     * @param arena Incompatible Arena object
     * @param session Incompatible Session object
     */
    public IncompatibleArenaSessionException(Arena arena, Session session) {
        super("Unable to create a session between incompatible types.");
    }

}
