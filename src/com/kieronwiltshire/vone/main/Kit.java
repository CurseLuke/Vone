package com.kieronwiltshire.vone.main;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

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
public abstract class Kit {

    // Instance variables
    private ItemStack[] contents;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;

    /**
     * Kit constructor
     *
     * @param contents The contents of the inventory
     * @param helmet The helmet item
     * @param chestplate The chestplate item
     * @param leggings The leggings item
     * @param boots The boots item
     */
    protected Kit(ItemStack[] contents, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        this.contents = contents;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    /**
     * Set the inventory contents
     *
     * @param contents ItemStack array
     */
    public void setContents(ItemStack... contents) {
        this.contents = contents;
    }

    /**
     * Get the contents of the Kit
     *
     * @return ItemStack array
     */
    @Nullable
    public ItemStack[] getContents() {
        return this.contents;
    }

    /**
     * Set the helmet item
     *
     * @param helmet ItemStack object
     */
    public void setHelmet(ItemStack helmet) {
        this.helmet = helmet;
    }

    /**
     * Get the Helmet item
     *
     * @return ItemStack object
     */
    @Nullable
    public ItemStack getHelmet() {
        return this.helmet;
    }

    /**
     * Set the chestplate item
     *
     * @param chestplate ItemStack object
     */
    public void setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
    }

    /**
     * Get the Chestplate item
     *
     * @return ItemStack object
     */
    @Nullable
    public ItemStack getChestplate() {
        return this.chestplate;
    }

    /**
     * Set the leggings item
     *
     * @param leggings ItemStack object
     */
    public void setLeggings(ItemStack leggings) {
        this.leggings = leggings;
    }

    /**
     * Get the Leggings item
     *
     * @return ItemStack object
     */
    @Nullable
    public ItemStack getLeggings() {
        return this.leggings;
    }

    /**
     * Set the boots item
     *
     * @param boots ItemStack object
     */
    public void setBoots(ItemStack boots) {
        this.boots = boots;
    }

    /**
     * Get the Boots item
     *
     * @return ItemStack object
     */
    @Nullable
    public ItemStack getBoots() {
        return this.boots;
    }

}
