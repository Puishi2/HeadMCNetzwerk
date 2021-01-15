package de.headmc.listener;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.manager.ActionbarManager;
import de.headmc.core.manager.ScoreboardManager;
import de.headmc.core.manager.SettingsManager;
import de.headmc.core.player.HeadMCPlayer;
import de.headmc.utils.Data;
import de.headmc.utils.LocationManager;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event){
        Player player = event.getPlayer();
        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());


       new Data().sendActionbar(player);
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());
        new Data().loadedefaultsSettings(player);
        event.setJoinMessage(null);


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
