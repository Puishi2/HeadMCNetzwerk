package de.headmc.listener;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.manager.ActionbarManager;
import de.headmc.core.manager.SettingsManager;
import de.headmc.core.player.HeadMCPlayer;
import de.headmc.effects.SpawnParticles;
import de.headmc.utils.Data;
import de.headmc.utils.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event){

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        event.setJoinMessage(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.setLevel(2021);
        player.setHealthScale(6);

        ActionbarManager.setTitle(player, "§8✗ §3HeadMC.de §8✗", "§7Willkommen auf HeadMC!", 10, 40, 10);

        if(SettingsManager.getSetting("player", player.getUniqueId().toString()) == 0) {
            Data.hidePlayer.forEach(hider -> {
                hider.hidePlayer(player);
            });
        } else {
            Data.hidePlayer.forEach(hider -> {
                hider.showPlayer(player);
            });
        }

        new Data().loadJoinitems(player);

        if(!new CoinsAPI().exists(player)) {
            new CoinsAPI().createPlayer(player);
        }
        if(!new SettingsManager().exists(player)) {
            new SettingsManager().createPlayer(player);
        }

        player.teleport(new LocationManager().getLocation("spawn"));

        new Data().createScoreboard(headMCPlayer, player);

        new Data().sendActionbar(player);

    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

}
