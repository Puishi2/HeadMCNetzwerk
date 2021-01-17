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
            event.setFormat("§8» §4Administrator §8┃ §4" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("SrDeveloper")) {
            event.setFormat("§8» §bSrDeveloper §8┃ §b" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Developer")) {
            event.setFormat("§8» §bDeveloper §8┃ §b" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("SrModerator")) {
            event.setFormat("§8» §9SrModerator §8┃ §9" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Content")) {
            event.setFormat("§8» §cContent §8┃ §c" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("SrContent")) {
            event.setFormat("§8» §cSrContent §8┃ §c" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Builder")) {
            event.setFormat("§8» §2Builder §8┃ §2" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Head")) {
            event.setFormat("§8» §3Head §8┃ §3" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Premium+")) {
            event.setFormat("§8» §6Premium§e+ §8┃ §6" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("YouTuber")) {
            event.setFormat("§8» §5YouTuber §8┃ §5" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Moderator")) {
            event.setFormat("§8» §9Moderator §8┃ §9" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Supporter")) {
            event.setFormat("§8» §3Supporter §8┃ §3" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Prime")) {
            event.setFormat("§8» §6Prime §8┃ §6" + player.getName() + " §8» §7" + event.getMessage());
        } else if(permissionPlayer.hasPermissionGroup("Freund")) {
            event.setFormat("§8» §fFreund §8┃ §f" + player.getName() + " §8» §7" + event.getMessage());
        } else {
            event.setFormat("§8» §7Spieler §8┃ §7" + player.getName() + " §8» §7" + event.getMessage());
        }

    }
}
