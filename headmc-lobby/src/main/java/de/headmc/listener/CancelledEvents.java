package de.headmc.listener;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.utils.Data;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class CancelledEvents implements Listener {

    @EventHandler
    public void onFood(final FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(final EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onWeather(final WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onInvClick(final InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        if(Data.build.contains(player)){
            event.setCancelled(false);
        }else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(final PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(final PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if(player.getGameMode() == GameMode.CREATIVE) {
            event.setCancelled(false);
        } else {
            event.setCancelled(true);
        }
    }

}
