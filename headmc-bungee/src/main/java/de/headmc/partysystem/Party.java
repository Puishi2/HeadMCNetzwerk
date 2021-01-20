package de.headmc.partysystem;

import de.headmc.data.Data;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * JavaDoc this file!
 * Created: 20.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class Party {

    public static ArrayList<String> partyleiter  = new ArrayList<>();
    public static HashMap<String, String> inparty = new HashMap<>();
    public static HashMap<String, Long> invitetime = new HashMap<>();
    public static HashMap<String, String> invite = new HashMap<>();

    private static Integer maxparty = Integer.valueOf(6);

    public static void neueParty(final ProxiedPlayer player) {
        if(inparty.containsKey(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + "Du bist in keiner Party!");
            return;
        }
        if(partyleiter.contains(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + "Du bist bereits in einer Party");
            return;
        }
        partyleiter.add(player.getName());
        player.sendMessage(Data.PARTY_PREFIX + "Du hast eine Party erstellt.");
    }

    public static void leave(final ProxiedPlayer player) {
        if(inparty.containsKey(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + "Du hast die Party verlassen.");
            for(ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
                if (inparty.get(x.getName()) != inparty.get(player.getName()))
                    continue;
                x.sendMessage(Data.PARTY_PREFIX + player.getName() + " hat die Party verlassen.");
                }
            inparty.remove(player.getName());
            return;
        }
        if(partyleiter.contains(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + "Die Party wurde wegen fehlenden Spielern aufgelöst.");
            partyleiter.remove(player.getName());
            for(ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
                if(!inparty.containsKey(x.getName()) || inparty.get(x.getName()) != player.getName())
                    continue;
                player.sendMessage(Data.PARTY_PREFIX + "Die Party wurde wegen fehlenden Spielern aufgelöst.");
                inparty.remove(x.getName());
            }
            return;
        }
        if (!inparty.containsKey(player.getName()) && !partyleiter.contains(player.getName()))
            player.sendMessage(Data.PARTY_PREFIX + "Du bist in keiner Party!");
    }

    public static void chat(final ProxiedPlayer player, final String text) {
    }

}
