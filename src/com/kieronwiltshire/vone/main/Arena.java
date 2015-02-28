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
public abstract class Arena {

    // Instance variables
    private String name;
    private String version;
    private String[] authors;
    private String[] description;
    private String download;
    private Location spawn;

    /**
     * Arena constructor
     *
     * @param name        The name of the arena
     * @param version     The version of the arena
     * @param authors     The authors of the arena
     * @param description The description of the arena
     * @param download    The download link for the arena
     * @param spawn       The spawn location of the arena
     */
    protected Arena(String name, String version, String[] authors, String[] description, String download, Location spawn) {
        this.name = name;
        this.version = version;
        this.authors = authors;
        this.description = description;
        this.download = download;
        this.spawn = spawn;
    }

    /**
     * Get the name of the arena
     *
     * @return String value
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the version of the arena
     *
     * @param version String value
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Get the version of the arena
     *
     * @return String value
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Set the authors of the arena
     *
     * @param authors String array
     */
    public void setAuthors(String... authors) {
        this.authors = authors;
    }

    /**
     * Get the authors of the arena
     *
     * @return String array
     */
    public String[] getAuthors() {
        return this.authors;
    }

    /**
     * Set the description for the arena
     *
     * @param description String array
     */
    public void setDescription(String... description) {
        this.description = description;
    }

    /**
     * Get the description of the arena
     *
     * @return String array
     */
    public String[] getDescription() {
        return this.description;
    }

    /**
     * Set the download link for the arena
     *
     * @param download String value
     */
    public void setDownload(String download) {
        this.download = download;
    }

    /**
     * Get the download link for the arena
     *
     * @return String value
     */
    public String getDownload() {
        return this.download;
    }

    /**
     * Set the spawn location for the arena
     *
     * @param spawn Location object
     */
    public void setSpawnLocation(Location spawn) { this.spawn = spawn; }

    /**
     * Get the spawn location for the arena
     *
     * @return Location object
     */
    public Location getSpawnLocation() {
        return this.spawn;
    }

}