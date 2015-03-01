package com.kieronwiltshire.vone.main.arenas;

import com.kieronwiltshire.vone.Vone;
import com.kieronwiltshire.vone.main.Arena;
import com.kieronwiltshire.vone.utilities.ConfigurationFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

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
public class BasicArena extends ConfigurationFile implements Arena {

    // Instance variables
    private String file;

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
        super(Vone.getInstance(), Vone.getInstance().getArenaFolder(), name.replace(" ", "").toLowerCase() + ".arena");

        this.file = name.replace(" ", "").toLowerCase() + ".arena";

        this.reload();

        this.name = name;
        this.version = version;
        this.authors = authors;
        this.description = description;
        this.download = download;
        this.spawn = spawn;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
        if (!super.doesFileExist()) {
            super.createFile();
        }

        super.getConfig().set("properties.name", this.name);
        super.getConfig().set("properties.version", this.version);
        super.getConfig().set("properties.authors", this.authors);
        super.getConfig().set("properties.description", this.description);
        super.getConfig().set("properties.download", this.download);

        super.getConfig().set("properties.spawn.x", this.spawn.getX());
        super.getConfig().set("properties.spawn.y", this.spawn.getY());
        super.getConfig().set("properties.spawn.z", this.spawn.getZ());
        super.getConfig().set("properties.spawn.yaw", this.spawn.getYaw());
        super.getConfig().set("properties.spawn.pitch", this.spawn.getPitch());
        super.getConfig().set("properties.spawn.world", this.spawn.getWorld().getName());

        super.save();
    }

    @Override
    public void delete() {
        if (super.doesFileExist()) {
            super.deleteFile();
        }
    }

    @Override
    public void reload() {
        if (super.doesFileExist()) {
            this.name = super.getConfig().getString("properties.name");
            this.version = super.getConfig().getString("properties.version");
            this.authors = super.getConfig().getStringList("properties.authors").toArray(new String[super.getConfig().getStringList("properties.authors").size()]);
            this.description = super.getConfig().getStringList("properties.description").toArray(new String[super.getConfig().getStringList("properties.description").size()]);
            this.download = super.getConfig().getString("properties.download");

            double x = super.getConfig().getDouble("properties.spawn.x");
            double y = super.getConfig().getDouble("properties.spawn.y");
            double z = super.getConfig().getDouble("properties.spawn.z");
            float yaw = super.getConfig().getInt("properties.spawn.yaw");
            float pitch = super.getConfig().getInt("properties.spawn.pitch");
            String worldName = super.getConfig().getString("properties.spawn.world");

            World world;
            if (Bukkit.getWorld(worldName) != null) {
                world = Bukkit.getWorld(worldName);
            } else {
                throw new NullPointerException("Unable to reload the `" + this.name + "` arena. The world was not found.");
            }

            this.spawn = new Location(world, x, y, z, yaw, pitch);
        }
    }

}