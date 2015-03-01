package com.kieronwiltshire.vone.main;

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
public interface Arena {

    /**
     * Set the name of the arena
     *
     * @param name The new name of the arena
     */
    public void setName(String name);

    /**
     * Get the name of the arena
     *
     * @return String value
     */
    public String getName();

    /**
     * Set the version of the arena
     *
     * @param version String value
     */
    public void setVersion(String version);

    /**
     * Get the version of the arena
     *
     * @return String value
     */
    public String getVersion();

    /**
     * Set the authors of the arena
     *
     * @param authors String array
     */
    public void setAuthors(String... authors);

    /**
     * Get the authors of the arena
     *
     * @return String array
     */
    public String[] getAuthors();

    /**
     * Set the description for the arena
     *
     * @param description String array
     */
    public void setDescription(String... description);

    /**
     * Get the description of the arena
     *
     * @return String array
     */
    public String[] getDescription();

    /**
     * Set the download link for the arena
     *
     * @param download String value
     */
    public void setDownload(String download);

    /**
     * Get the download link for the arena
     *
     * @return String value
     */
    public String getDownload();

    /**
     * Set the spawn location for the arena
     *
     * @param spawn Location object
     */
    public void setSpawnLocation(Location spawn);

    /**
     * Get the spawn location for the arena
     *
     * @return Location object
     */
    public Location getSpawnLocation();

    /**
     * Save the Arena information to flat file
     */
    public void save();

    /**
     * Delete the Arena flat file if one exists
     */
    public void delete();

}
