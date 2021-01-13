package de.headmc.listener.lobbyitems;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ExtraListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lExtras §8× §7Rechtsclick")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §3§lExtras §8× §7Rechtsclick");
            InventoryBuilder.setInvRand(inventory, player);

            inventory.setItem(20, new ItemManager(Material.FISHING_ROD).setDisplayName("§8» §aGadgets").toItemStack());
            inventory.setItem(22, new ItemManager(Material.INK_SACK).setDisplayName("§8» §eSpuren").setDurability((short) 11).toItemStack());
            inventory.setItem(24, new ItemManager(Material.GOLD_NUGGET).setDisplayName("§8» §6Shop").toItemStack());
            inventory.setItem(30, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());
            inventory.setItem(32, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());

            player.openInventory(inventory);

        }

    }

}
