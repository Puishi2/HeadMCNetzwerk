package de.headmc.partysystem;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * JavaDoc this file!
 * Created: 20.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class PartyCommand extends Command {

    public PartyCommand() {
        super("Party", null, "p");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            final ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length < 1) {
                player.sendMessage("§8§m--------------------------------------");
                player.sendMessage(Data.PARTY_PREFIX + "§7Lade einen Spieler ein: §5/party invite §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Verlasse die Party: §5/party leave");
                player.sendMessage(Data.PARTY_PREFIX + "§7Nehme eine Einladung an: §5/party accept §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Kicke einen Spieler: §5/party kick §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Party-Chat: §5/party msg §7<Nachricht>");
                player.sendMessage("§8§m--------------------------------------");
            } else if(args[0].equalsIgnoreCase("create")) {
                Party.neueParty(player);
            } else if(args[0].equalsIgnoreCase("list")) {
                Party.List(player);
            } else if(args[0].equalsIgnoreCase("leave")) {
                Party.leave(player);
            } else if (args[0].equalsIgnoreCase("invite")) {
                if (args.length > 1) {
                    for (ProxiedPlayer target : ProxyServer.getInstance().getPlayers()) {
                        if (!target.getName().equalsIgnoreCase(args[1]))
                            continue;
                        ProxiedPlayer z = ProxyServer.getInstance().getPlayer(args[1]);
                        Party.invite(player, z);
                        return;
                    }
                    player.sendMessage(Data.PARTY_PREFIX + "Dieser Spieler ist nicht Online.");
                } else {
                    player.sendMessage(Data.PARTY_PREFIX + "Nutze §5/party invite §7<Spieler>");
                }
            } else if(args[0].equalsIgnoreCase("accept")) {
                Party.accept(player);
            } else if(args[0].equalsIgnoreCase("msg")) {
                if (Party.inparty.containsKey(player) || Party.partyleiter.contains(player)) {
                    String msg2 = "";
                    int i = 0;
                    while (i < args.length) {
                        msg2 = String.valueOf(String.valueOf(msg2)) + args[i] + " ";
                        Party.chat(player, msg2);
                        i++;
                    }
                } else {
                    player.sendMessage(Data.PARTY_PREFIX + "Du befindest dich in keiner Party.");
                }
            } else if(args[0].equalsIgnoreCase("kick")) {
                if(args.length > 1) {
                    for (ProxiedPlayer target : ProxyServer.getInstance().getPlayers()) {
                        if(!target.getName().equalsIgnoreCase(args[1]))
                            continue;
                        Party.kick(player, target);
                        return;
                    }
                    player.sendMessage(Data.PARTY_PREFIX + "Dieser Spieler ist nicht online.");
                } else {
                    player.sendMessage(Data.PARTY_PREFIX + "Verwende §5/party kick §7<Spieler>");
                }
            } else if(args[0].equalsIgnoreCase("help")) {
                player.sendMessage("§8§m--------------------------------------");
                player.sendMessage(Data.PARTY_PREFIX + "§7Lade einen Spieler ein: §5/party invite §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Verlasse die Party: §5/party leave");
                player.sendMessage(Data.PARTY_PREFIX + "§7Nehme eine Einladung an: §5/party accept §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Kicke einen Spieler: §5/party kick §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Party-Chat: §5/party msg §7<Nachricht>");
                player.sendMessage("§8§m--------------------------------------");
            } else {
                player.sendMessage("§8§m--------------------------------------");
                player.sendMessage(Data.PARTY_PREFIX + "§7Lade einen Spieler ein: §5/party invite §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Verlasse die Party: §5/party leave");
                player.sendMessage(Data.PARTY_PREFIX + "§7Nehme eine Einladung an: §5/party accept §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Kicke einen Spieler: §5/party kick §7<Spieler>");
                player.sendMessage(Data.PARTY_PREFIX + "§7Party-Chat: §5/party msg §7<Nachricht>");
                player.sendMessage("§8§m--------------------------------------");
            }
        }
    }
}
