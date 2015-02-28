package com.kieronwiltshire.vone.utilities;

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
public enum Environment {

    // Environments
    PRODUCTION(0),
    TESTING(1),
    DEVELOPMENT(2);

    // Instance variables
    private int value;

    /**
     * Environment constructor
     *
     * @param value The status of the environment
     */
    private Environment(int value) {
        this.value = value;
    }

    /**
     * The status of the environment
     *
     * @return Integer value
     */
    public int getStatus() {
        return this.value;
    }

}
