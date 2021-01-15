package de.headmc.listener.lobbyitems.gadgets;

import de.headmc.core.manager.ItemManager;
import de.headmc.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

import java.util.HashMap;

public class Enderperle implements Listener {

    private HashMap<Player, EnderPearl> enderpearls = new HashMap<>();

    @EventHandler
    public void handlePlayerInteract(final PlayerInteractEvent event) {
        try {

            if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Enderperle")) {

                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

                    Player player = event.getPlayer();
                    event.setCancelled(true);
                    player.getInventory().setItem(4, new ItemManager(Material.CLAY_BALL).setDisplayName("§8» §7Bitte waren...").toItemStack());
                    player.updateInventory();
                    EnderPearl enderpearl = (EnderPearl) player.launchProjectile(EnderPearl.class);
                    enderpearl.setPassenger(player);
                    this.enderpearls.put(player, enderpearl);

                    Bukkit.getScheduler().runTaskLater(Lobby.getInstance(), () -> {
                        if (player.getInventory().contains(new ItemManager(Material.CLAY_BALL).setDisplayName("§8» §7Bitte waren...").toItemStack())) {
                            player.getInventory().setItem(4, new ItemManager(Material.ENDER_PEARL).setDisplayName("§8» §5Enderperle").toItemStack());
                            player.updateInventory();
                            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                        }

                    }, 100L);

                }

            }

        } catch (Exception exception) {
        }

    }

    @EventHandler
    public void handleVehicleLeave(final VehicleExitEvent event) {

        if (event.getExited() instanceof Player && this.enderpearls.containsKey(event.getExited()))
            ((EnderPearl) this.enderpearls.get(event.getExited())).remove();
    }

}
