package de.headmc.listener.chat;

import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event){

        Player player = event.getPlayer();
        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

        event.getMessage().replace('%', '&');

        if(permissionPlayer.hasPermissionGroup("Admin")) {
            event.setFormat("§4Administrator §8┃ §4" + player.getName() + " §8» §7" + event.getMessage());
        }

    }
}
