package com.kieronwiltshire.vone.utilities;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.logging.Level;

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
public class ConfigurationFile {

    // Configuration related variables
    private FileConfiguration config;
    private File configFile;

    // File related variables
    private JavaPlugin plugin;
    private File path;
    private String name;

    /**
     * Create a new configuration file instance
     *
     * @param plugin JavaPlugin object
     * @param path   the path to the file
     * @param name   the name of the configuration file
     */
    public ConfigurationFile(JavaPlugin plugin, File path, String name) {
        this.plugin = plugin;
        this.path = path;
        this.name = name + ".yml";
        path.mkdirs();
    }

    /**
     * Get the name of the file
     *
     * @return the name of the file
     */
    public String getFileName() {
        return this.name.replace(".yml", "");
    }

    /**
     * Get the configuration file
     *
     * @return File object
     */
    public File getFile() {
        return new File(this.path, name);
    }

    /**
     * Check if the configuration file exists
     *
     * @return true if the configuration file exists
     */
    public boolean doesFileExist() {
        if (new File(this.path, this.name).exists()) {
            return true;
        }

        return false;
    }

    /**
     * Get the configuration file
     *
     * @return FileConfiguration object
     */
    public FileConfiguration getConfig() {
        if (this.config == null) {
            this.reload();
        }

        return this.config;
    }

    /**
     * Reload the configuration file
     */
    public void reload() {
        if (this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), this.name);
        }

        this.config = YamlConfiguration.loadConfiguration(this.configFile);
        File defConfigFile = new File(this.path, this.name);

        if (defConfigFile != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigFile);
            this.config.setDefaults(defConfig);
        }
    }

    /**
     * Save the configuration file
     */
    public void save() {
        if ((this.config == null) || (this.configFile == null)) {
            return;
        }

        try {
            this.getConfig().save(this.configFile);
        } catch (IOException ex) {
            this.plugin.getLogger().log(Level.SEVERE, "Error whilst saving " + this.configFile, ex);
        }
    }

    /**
     * Save a copy of the default configuration file
     */
    public void copy() {
        if (this.configFile == null) {
            this.configFile = new File(this.path, this.name);
        }

        if (!this.configFile.exists()) {
            InputStream is = this.plugin.getResource(this.name);

            if (is != null) {
                OutputStream resStreamOut = null;
                int readBytes;
                byte[] buffer = new byte[4096];

                try {
                    resStreamOut = new FileOutputStream(new File(this.path + File.separator + this.name));
                    while ((readBytes = is.read(buffer)) > 0) {
                        resStreamOut.write(buffer, 0, readBytes);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        is.close();
                        resStreamOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Create a blank configuration file
     */
    public void createFile() {
        if (!new File(this.path, this.name).exists()) {
            try {
                new File(this.path, this.name).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Delete the configuration file
     */
    public void deleteFile() {
        if (new File(this.path, this.name).exists()) {
            new File(this.path, this.name).delete();
        }
    }

    /**
     * Rename the current file
     *
     * @param name String value
     */
    public void renameFile(String name) {
        this.getFile().renameTo(new File(this.path, name + ".yml"));
    }

}
