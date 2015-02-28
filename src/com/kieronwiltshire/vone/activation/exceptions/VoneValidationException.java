package com.kieronwiltshire.vone.activation.exceptions;

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
public class VoneValidationException extends Exception {

    /**
     * Throw a VoneValidationException error
     */
    public VoneValidationException() {
        super("Vone is unable to operate unvalidated.");
    }

}
