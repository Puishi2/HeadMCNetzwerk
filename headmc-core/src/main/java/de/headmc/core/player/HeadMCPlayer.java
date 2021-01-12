package de.headmc.core.player;

import de.headmc.core.data.Data;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.group.IPermissionGroup;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HeadMCPlayer {

    private final String username;
    private final UUID uuid;
    private static HashMap<String, UUID> players = new HashMap<String, UUID>();
    private static HashMap<UUID, String> playerNames = new HashMap<UUID, String>();

    public HeadMCPlayer(String username, UUID uuid) {
        this.username = username;
        this.uuid = uuid;
        players.put(username, uuid);
        playerNames.put(uuid, username);
    }

    public String getUsername() {
        if(uuid != null) return username;
        return "§cNot found";
    }

    public UUID getUniqueId() {
        if (uuid != null) return uuid;
        return null;
    }

    public void sendMessageToSpigotPlayer(final Player player, String message) {
        player.sendMessage(Data.NETWORK_PREFIX + message);
    }

    public void sendMessageToProxyPlayer(final ProxiedPlayer player, String message) {
        player.sendMessage(Data.NETWORK_PREFIX + message);
    }

    public void sendNoPermissionMessageToProxyPlayer(final ProxiedPlayer player){
        player.sendMessage(Data.NETWORK_PREFIX + "§7Dazu hast du §ckeine Rechte§8!");
    }

    public void sendNoPermissionMessage(final Player player){
        player.sendMessage(Data.NETWORK_PREFIX + "§7Dazu hast du §ckeine Rechte§8!");
    }

    public List getRank(Player player) {
        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());
        List<IPermissionGroup> permissionGroups = permissionPlayer.getAllNotExpiredPermissionGroups();
        return permissionGroups;
    }

}
