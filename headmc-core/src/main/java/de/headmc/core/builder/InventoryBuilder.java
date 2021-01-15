package de.headmc.core.builder;

import de.headmc.core.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    public static Inventory createInventory(Player player, int size, String title) {
        return Bukkit.createInventory(player, size, title);
    }

    public static void setInvRand(Inventory inventory, Player player){

        ItemStack bluePane = new ItemStack(new ItemManager(Material.STAINED_GLASS_PANE).setDurability((short) 9).setDisplayName("§8 ").toItemStack());
        ItemStack blackPane = new ItemStack(new ItemManager(Material.STAINED_GLASS_PANE).setDurability((short) 15).setDisplayName("§8 ").toItemStack());

        for (int i =0;i<54;i++){
            inventory.setItem(i,blackPane);
        }
        inventory.setItem(0, bluePane);
        inventory.setItem(1, bluePane);
        inventory.setItem(7, bluePane);
        inventory.setItem(8, bluePane);
        inventory.setItem(9, bluePane);
        inventory.setItem(17, bluePane);
        inventory.setItem(36, bluePane);
        inventory.setItem(44, bluePane);
        inventory.setItem(45, bluePane);
        inventory.setItem(46, bluePane);
        inventory.setItem(52, bluePane);
        inventory.setItem(53, bluePane);
    }

}
