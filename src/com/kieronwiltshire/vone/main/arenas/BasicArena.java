package com.kieronwiltshire.vone.main.arenas;

import com.kieronwiltshire.vone.main.Arena;
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
public abstract class BasicArena implements Arena {

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
    protected BasicArena(String name, String version, String[] authors, String[] description, String download, Location spawn) {
        this.name = name;
        this.version = version;
        this.authors = authors;
        this.description = description;
        this.download = download;
        this.spawn = spawn;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String getVersion() {
        return this.version;
    }

    @Override
    public void setAuthors(String... authors) {
        this.authors = authors;
    }

    @Override
    public String[] getAuthors() {
        return this.authors;
    }

    @Override
    public void setDescription(String... description) {
        this.description = description;
    }

    @Override
    public String[] getDescription() {
        return this.description;
    }

    @Override
    public void setDownload(String download) {
        this.download = download;
    }

    @Override
    public String getDownload() {
        return this.download;
    }

    @Override
    public void setSpawnLocation(Location spawn) { this.spawn = spawn; }

    @Override
    public Location getSpawnLocation() {
        return this.spawn;
    }

    @Override
    public void save() {
        // TODO save to config
    }

}