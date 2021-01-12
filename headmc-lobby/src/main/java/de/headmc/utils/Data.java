package de.headmc.utils;

import de.headmc.core.Core;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Data {

    public void loadJoinitems(Player player){

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        ItemStack nav = new ItemManager(Material.BOOK).setDisplayName("§8» §bNavigator").toItemStack();

        player.getInventory().setItem(1, nav);
        player.getInventory().setItem(4, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622")).setDisplayName("§8» §3Extras").toItemStack());
        player.getInventory().setItem(7, new ItemManager(Material.REDSTONE_COMPARATOR).setDisplayName("§8» §3Einstellungen").toItemStack());

    }

}
