package com.kieronwiltshire.vone.main.kits;

import com.kieronwiltshire.vone.main.Kit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
public class VoneKit extends Kit {

    /**
     * Create a default PVP Kit
     */
    public VoneKit() {
        super(null, new ItemStack(Material.IRON_HELMET), new ItemStack(Material.IRON_CHESTPLATE), new ItemStack(Material.IRON_LEGGINGS), new ItemStack(Material.IRON_BOOTS));
        super.setContents(
            /* TODO */
        );
    }

}
