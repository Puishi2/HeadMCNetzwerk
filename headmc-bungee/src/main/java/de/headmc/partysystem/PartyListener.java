package de.headmc.partysystem;

import de.headmc.data.Data;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * JavaDoc this file!
 * Created: 21.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class PartyListener implements Listener {

    @EventHandler
    public void onSwitch(final ServerSwitchEvent event) {
        final ProxiedPlayer player = event.getPlayer();
        if(Party.partyleiter.contains(player.getName())) {
            ServerInfo serverInfo = player.getServer().getInfo();
            player.sendMessage(Data.PARTY_PREFIX + "Die Party hat den Server §5" + serverInfo.getName() + "§7 betreten.");
            for (ProxiedPlayer party : ProxyServer.getInstance().getPlayers()) {
                if(!Party.inparty.containsKey(party.getName()) || Party.inparty.get(party.getName()) != player.getName())
                    continue;
                player.sendMessage(Data.PARTY_PREFIX + "Die Party hat den Server §5" + serverInfo.getName() + "§7 betreten.");
                party.connect(serverInfo);
            }
        }
    }

    @EventHandler
    public void onleave(PlayerDisconnectEvent event) {
        final ProxiedPlayer player = event.getPlayer();
        if(Party.partyleiter.contains(player.getName()))
            Party.leave(player);
    }

}
