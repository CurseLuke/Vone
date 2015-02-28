package com.kieronwiltshire.vone;

import com.kieronwiltshire.vone.activation.Validator;
import com.kieronwiltshire.vone.utilities.ConfigurationFile;
import com.kieronwiltshire.vone.main.Game;
import com.kieronwiltshire.vone.utilities.Environment;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

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
public class Vone extends JavaPlugin implements Listener {

    // Class variables
    private static Vone instance;
    private static Environment ENVIRONMENT = Environment.DEVELOPMENT;

    /**
     * Get the Vone plugin instance
     *
     * @return Vone object
     */
    public static Vone getInstance() {
        return Vone.instance;
    }

    /**
     * Get the environment status of the application
     *
     * @return Environment enumerator value
     */
    public static Environment getEnvironment() {
        return Vone.ENVIRONMENT;
    }

    /**
     * Set the environment status of the application
     *
     * @param ENVIRONMENT enumerator value
     */
    public static void setEnvironment(Environment ENVIRONMENT) {
        Vone.ENVIRONMENT = ENVIRONMENT;
    }

    // Instance variables
    private ConfigurationFile settings;
    private boolean validated;

    /**
     * This method is called when the plugin is enabled
     */
    public void onEnable() {
        Vone.instance = this;

        this.settings = new ConfigurationFile(this, this.getDataFolder(), "settings");
        this.settings.copy();

        if (!Validator.isValid(this.getActivationKey())) {
            this.validated = false;
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "The activation key provided is invalid. [Vone] disabled.");
            Bukkit.getConsoleSender().sendMessage("");
        } else {
            this.validated = true;
            this.init();
        }
    }

    /**
     * This method is called once all the validation checks are complete
     */
    private void init() {
        this.getServer().getPluginManager().registerEvents(Game.getInstance(), this);
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, Game.getInstance(), 0L, 20L);
    }

    /**
     * Get the configuration file
     *
     * @return ConfigurationFile object
     */
    public ConfigurationFile getConfigFile() {
        return this.settings;
    }

    /**
     * Get the folder where all of the arena configuration files are stored
     *
     * @return File object
     */
    public File getArenaFolder() {
        return new File(this.getDataFolder(), "arenas");
    }

    /**
     * Get the plugin activation key
     *
     * @return String value
     */
    public String getActivationKey() {
        return this.settings.getConfig().getString("settings.activation_key");
    }

    /**
     * Check if the plugin has been validated
     *
     * @return Boolean value
     */
    public boolean isValidated() {
        return this.validated;
    }

    @Override
    public FileConfiguration getConfig() {
        return this.settings.getConfig();
    }

}
