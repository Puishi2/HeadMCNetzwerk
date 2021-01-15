package de.headmc.listener.lobbyitems;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import de.headmc.utils.Data;
import de.headmc.utils.LocationManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NavigatorListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§LNavigator §8× §7Rechtsclick")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §3§lNavigator §8- §7SpielModie");

            InventoryBuilder.setInvRand(inventory, player);

            inventory.setItem(40, new ItemManager(Material.FIREWORK_CHARGE).addEnchant(Enchantment.THORNS, 3)
                    .addLoreLine("§8» §7Teleportiere dich zum Spawn.").setFlags().setDisplayName("§8» §a§lSpawn").toItemStack());
            inventory.setItem(12, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/6fb290a13df88267ea5f5fcf796b6157ff64ccee5cd39d469724591babeed1f6"))
                    .setDisplayName("§8» §c§lBedWars").addLoreLine("§8» §7Teleportiere dich zu BedWars.").toItemStack());
            inventory.setItem(14, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/c95d37993e594082678472bf9d86823413c250d4332a2c7d8c52de4976b362"))
                    .setDisplayName("§8» §2§lSkyWars").addLoreLine("§8» §7Teleportiere dich zu SkyWars.").toItemStack());
            inventory.setItem(19, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))
                    .setDisplayName("§8» §c§lKommt bald...").toItemStack());
            inventory.setItem(25, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))
                    .setDisplayName("§8» §c§lKommt bald...").toItemStack());
            inventory.setItem(30, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/a6cc486c2be1cb9dfcb2e53dd9a3e9a883bfadb27cb956f1896d602b4067"))
                    .setDisplayName("§8» §5§lLottery").addLoreLine("§8» §7Teleportiere dich zur Lottery.").toItemStack());
            inventory.setItem(32, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622"))
                    .setDisplayName("§8» §6§lCase Opening").addLoreLine("§8» §7Teleportiere dich zu Case Opening.").toItemStack());

            player.openInventory(inventory);

        }

    }

    @EventHandler
    public void onClick(final InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §3§lNavigator §8- §7SpielModie")){
           if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §a§lSpawn")){
               new Data().navigatorTeleport(player, new LocationManager().getLocation("spawn"));
           } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lBedWars")){
                new Data().navigatorTeleport(player, new LocationManager().getLocation("bedwars"));
           } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lSkyWars")){
               new Data().navigatorTeleport(player, new LocationManager().getLocation("skywars"));
           } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2§lSkyWars")){
               new Data().navigatorTeleport(player, new LocationManager().getLocation("skywars"));
           } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lLottery")){
               new Data().navigatorTeleport(player, new LocationManager().getLocation("lottery"));
           } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lCase Opening")){
               new Data().navigatorTeleport(player, new LocationManager().getLocation("case"));
           }
        }

    }

}
