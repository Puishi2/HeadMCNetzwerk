package de.headmc.listener;

import de.headmc.core.Core;
import de.headmc.core.api.CoinsAPI;
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

        new Data().loadJoinitems(player);

        /*
        if(!Core.getInstance().getCoinsAPI().exists(player)) {

            Core.getInstance().getCoinsAPI().createPlayer(player);

        }
         */
        new CoinsAPI().createPlayer(player);

    }

}
