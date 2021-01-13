package de.headmc.listener;

import de.headmc.core.manager.SettingsManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class HotbarSounds implements Listener {

    @EventHandler
    public void onSwitch(final PlayerItemHeldEvent event) {

        Player player = event.getPlayer();

        if(SettingsManager.getSoundSettings(player.getUniqueId().toString()) == 1) {
            player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1, 1);
        } else {
            return;
        }

    }

}
