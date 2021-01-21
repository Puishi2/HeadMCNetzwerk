package de.headmc.partysystem;

import de.headmc.data.Data;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

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

    public static void chat(final ProxiedPlayer player, String text) {
        text = ChatColor.translateAlternateColorCodes('&', text);
        if (partyleiter.contains(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + player.getName() + " §7§ " + text);
            for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
                if (!inparty.containsKey(x.getName()) || inparty.get(x.getName()) != player.getName())
                    continue;
                x.sendMessage(Data.PARTY_PREFIX + player.getName() + " §7§ " + text);
            }
        }
        if (inparty.containsKey(player.getName())) {
            ProxyServer.getInstance().getPlayer(inparty.get(player.getName())).sendMessage(Data.PARTY_PREFIX + player.getName() + " §8:§7 " + text);
            for (ProxiedPlayer x : ProxyServer.getInstance().getPlayers()) {
                if (!inparty.containsKey(x.getName()) || inparty.get(x.getName()) != inparty.get(player.getName()))
                    continue;
                x.sendMessage(Data.PARTY_PREFIX + player.getName() + " §7§ " + text);
            }
        }
        if (!inparty.containsKey(player.getName()) && !partyleiter.contains(player.getName()))
            player.sendMessage(Data.PARTY_PREFIX + "Du bist in keiner Party.");
    }

    public static void invite(final ProxiedPlayer player, final ProxiedPlayer target) {
        long aktuell = System.currentTimeMillis();
        if (partyleiter.contains(player.getName())) {
            Integer iparty = Integer.valueOf(0);
            for (ProxiedPlayer i : ProxyServer.getInstance().getPlayers()) {
                if (!inparty.containsKey(i.getName()) || inparty.get(i.getName()) != player.getName())
                    continue;
                iparty = Integer.valueOf(iparty.intValue() + 1);
            }
            if (iparty.intValue() >= maxparty.intValue()) {
                player.sendMessage(Data.PARTY_PREFIX + "Die Party ist bereits voll.");
                return;
            }
            if (inparty.containsKey(target.getName())) {
                player.sendMessage(Data.PARTY_PREFIX + "Dieser Spieler befindet sich bereits in einer Party.");
                return;
            }
            if (partyleiter.contains(target.getName())) {
                player.sendMessage(Data.PARTY_PREFIX + "Dieser Spieler befindet sich bereits in einer Party.");
                return;
            }
            if (!inparty.containsKey(target.getName()) && !partyleiter.contains(target.getName())) {
                invite.put(target.getName(), player.getName());
                invitetime.put(target.getName(), Long.valueOf(aktuell));
                player.sendMessage(Data.PARTY_PREFIX + "Du hast den Spieler " + target.getName() + " eingeladen." );
                target.sendMessage(Data.PARTY_PREFIX + player.getName() + " hat dich zu seiner Party eingeladen.");
                target.sendMessage(Data.PARTY_PREFIX + "Betrete die Party mit §5/party accept " + player.getName() + "§7.");
                return;
            }
        } else if (inparty.containsKey(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + "Du darfst keine Spieler einladen.");
        } else if (!inparty.containsKey(player.getName()) && !partyleiter.contains(player.getName())) {
            neueParty(player);
            invite(player, target);
        }
    }

    public static void accept(final ProxiedPlayer player) {
        if (invite.containsKey(player.getName())) {
            Long aktuell = Long.valueOf(System.currentTimeMillis());
            Long diff = Long.valueOf(aktuell.longValue() / 1000L - ((Long)invitetime.get(player.getName())).longValue() / 1000L);
            if (diff.longValue() > 60L) {
                player.sendMessage(Data.PARTY_PREFIX + "Diese Einladung ist bereits abgelaufen.");
            } else {
                ProxiedPlayer Leiter = ProxyServer.getInstance().getPlayer(invite.get(player.getName()));
                Leiter.sendMessage(Data.PARTY_PREFIX + "§5" + player.getName() + " §7hat die Party betreten.");
                invite.remove(player.getName());
                invitetime.remove(player.getName());
                inparty.put(player.getName(), Leiter.getName());
                player.sendMessage(Data.PARTY_PREFIX + "Du hast die Party von §5" + Leiter.getName() + " §7betreten.");
            }
        } else {
            player.sendMessage(Data.PARTY_PREFIX + "Du wurdest nicht eingeladen.");
        }
    }

    public static void kick(final ProxiedPlayer player, final ProxiedPlayer p) {
        if (partyleiter.contains(player.getName())) {
            if (inparty.containsKey(p.getName()) && inparty.get(p.getName()) == player.getName()) {
                inparty.remove(p.getName());
                p.sendMessage("Du wurdest von §5" + player.getName() + " §7aus der Party geworfen.");
                player.sendMessage(Data.PARTY_PREFIX + "Der Spieler §5" + p.getName() + "§7 wurde gekickt.");
                for (ProxiedPlayer inpartyplayer : ProxyServer.getInstance().getPlayers()) {
                    if (!inparty.containsKey(inpartyplayer.getName()) || inparty.get(inpartyplayer.getName()) != player.getName())
                        continue;
                    inpartyplayer.sendMessage(Data.PARTY_PREFIX + "§5" + p.getName() + "§7 wurde von §5" + player.getName() + "§7 aus der Party geworfen.");
                }
            } else {
                player.sendMessage(Data.PARTY_PREFIX + "Dieser Spieler ist in keiner Party.");
            }
        } else {
            player.sendMessage(Data.PARTY_PREFIX + "Du bist in keiner Party.");
        }
    }

    public static void List(final ProxiedPlayer player) {
        if (partyleiter.contains(player.getName())) {
            player.sendMessage(Data.PARTY_PREFIX + "Leiter§8: §5" + player.getName() + " §8- §7" + player.getServer().getInfo().getName());
            player.sendMessage(Data.PARTY_PREFIX + "Mitglieder§8: ");
            for (ProxiedPlayer mitglieder : ProxyServer.getInstance().getPlayers()) {
                if (!inparty.containsKey(mitglieder.getName()) || inparty.get(mitglieder.getName()) != player.getName())
                    continue;
                player.sendMessage(Data.PARTY_PREFIX + "§5" + mitglieder.getName() + "§8 - §7" + mitglieder.getServer().getInfo().getName());
            }
        }
        if (inparty.containsKey(player.getName())) {
            try {
                player.sendMessage(Data.PARTY_PREFIX + "Leiter§8: §5" + (String)inparty.get(player.getName()) + "§8 - §7" + ProxyServer.getInstance().getPlayer(inparty.get(player.getName())).getServer().getInfo().getName());
            } catch (NullPointerException nullPointerException) {}
            for (ProxiedPlayer mitglieder : ProxyServer.getInstance().getPlayers()) {
                if (!inparty.containsKey(mitglieder.getName()) || inparty.get(mitglieder.getName()) != inparty.get(player.getName()))
                    continue;
                player.sendMessage(Data.PARTY_PREFIX + "§5" + mitglieder.getName() + "§8 - §7" + mitglieder.getServer().getInfo().getName());
            }
        }
        if (!inparty.containsKey(player.getName()) && !partyleiter.contains(player.getName()))
            player.sendMessage(Data.PARTY_PREFIX + "Du bist in keiner Party.");
    }

}
