package de.headmc.listener.navigator;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import de.headmc.utils.LocationManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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

            inventory.setItem(22, new ItemManager(Material.FIREWORK).addEnchant(Enchantment.THORNS, 3)
                    .addLoreLine("§8» §7Teleportiere dich zum Spawn.").setFlags().setDisplayName("§a§lSpawn").toItemStack());

            player.openInventory(inventory);

        }

    }

    @EventHandler
    public void onClick(final InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();


        if(event.getInventory().getTitle().equalsIgnoreCase("§8» §b§lNavigator §8- §7SpielModie")){
           if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")){
               player.teleport(new LocationManager().getLocation("spawn"));
           }
        }

    }

}
