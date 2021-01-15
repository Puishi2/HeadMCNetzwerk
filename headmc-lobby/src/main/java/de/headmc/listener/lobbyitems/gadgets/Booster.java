package de.headmc.listener.lobbyitems.gadgets;

import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import de.headmc.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class Booster implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cBooster")) {

            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

                event.setCancelled(true);
                player.setVelocity(new Vector(0, 30, 0));
                player.getInventory().setItem(4, new ItemManager(Material.CLAY_BALL).setDisplayName("§8» §7Bitte waren...").toItemStack());
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 10);
                player.updateInventory();

                Bukkit.getScheduler().runTaskLater(Lobby.getInstance(), () -> {
                    if (player.getInventory().contains(new ItemManager(Material.CLAY_BALL).setDisplayName("§8» §7Bitte waren...").toItemStack())) {
                        player.getInventory().setItem(4, new ItemManager(Material.FLINT).setDisplayName("§8» §cBooster").toItemStack());
                        player.updateInventory();
                        player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 1.0F, 1.0F);
                    }

                }, 100L);

            }

        }

    }

}
