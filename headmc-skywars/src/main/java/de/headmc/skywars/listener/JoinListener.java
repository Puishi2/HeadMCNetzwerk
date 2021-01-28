package de.headmc.skywars.listener;

import de.headmc.core.player.HeadMCPlayer;
import de.headmc.skywars.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        event.setJoinMessage(Data.PREFIX + "Der Spieler §2" + player.getName() + " §7hat die Runde betreten!");

        new Data().createStartItems(player);

    }

}
