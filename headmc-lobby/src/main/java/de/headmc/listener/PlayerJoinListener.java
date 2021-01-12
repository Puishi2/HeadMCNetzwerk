package de.headmc.listener;

import de.headmc.core.Core;
import de.headmc.utils.Data;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.ADVENTURE);
        player.setLevel(2021);

        if(!Core.getInstance().getCoinsAPI().exists(player)) {

            Core.getInstance().getCoinsAPI().createPlayer(player);

        }

        if(!player.hasPlayedBefore()) {

            Core.getInstance().getCoinsAPI().addCoins(player, 1000);

        }

        Data.loadJoinitems(player);

    }

}
