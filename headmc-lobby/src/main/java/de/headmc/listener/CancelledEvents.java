package de.headmc.listener;

import de.headmc.core.builder.InventoryBuilder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
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
        event.setCancelled(true);
    }

}
