package de.headmc.skywars.utils;

import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Data {

    public static String PREFIX = "§8» §2§lSkyWars §8§l│ §7";

    public void createStartItems(Player player) {

        player.getInventory().setItem(0, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622")).setDisplayName("§8» §2§lKits").toItemStack());
        player.getInventory().setItem(1, new ItemManager(Material.FIREWORK_CHARGE).setDisplayName("§8» §a§lKits").toItemStack());
        player.getInventory().setItem(4, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/6fb290a13df88267ea5f5fcf796b6157ff64ccee5cd39d469724591babeed1f6")).setDisplayName("§8» §5§lTeam").toItemStack());
        player.getInventory().setItem(7, new ItemManager(Material.REDSTONE_COMPARATOR).setDisplayName("§8» §4§lEinstellungen").toItemStack());
        player.getInventory().setItem(8, new ItemManager(Material.MAGMA_CREAM).setDisplayName("§8» §c§lVerlassen").toItemStack());

    }

}
