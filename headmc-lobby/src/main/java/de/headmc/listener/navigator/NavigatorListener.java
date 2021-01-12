package de.headmc.listener.navigator;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.player.HeadMCPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class NavigatorListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §bNavigator")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §bNavigator");
            InventoryBuilder.setInvRand(inventory, player);
            player.openInventory(inventory);

        }

    }

}
