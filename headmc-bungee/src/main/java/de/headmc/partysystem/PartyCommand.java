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
                player.sendMessage("§7Lade einen Spieler ein: §2/party invite §7<Spieler>");
                player.sendMessage("§7Verlasse die Party: §2/party leave");
                player.sendMessage("§7Nehme eine Einladung an: §2/party accept §7<Spieler>");
                player.sendMessage("§7Kicke einen Spieler: §2/party kick §7<Spieler>");
                player.sendMessage("§7Partychat: §2/pc §7<Nachricht>");
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
                player.sendMessage("§7Lade einen Spieler ein: §2/party invite §7<Spieler>");
                player.sendMessage("§7Verlasse die Party: §2/party leave");
                player.sendMessage("§7Nehme eine Einladung an: §2/party accept §7<Spieler>");
                player.sendMessage("§7Kicke einen Spieler: §2/party kick §7<Spieler>");
                player.sendMessage("§7Partychat: §2/pc §7<Nachricht>");
            } else {
                player.sendMessage("§7Lade einen Spieler ein: §2/party invite §7<Spieler>");
                player.sendMessage("§7Verlasse die Party: §2/party leave");
                player.sendMessage("§7Nehme eine Einladung an: §2/party accept §7<Spieler>");
                player.sendMessage("§7Kicke einen Spieler: §2/party kick §7<Spieler>");
                player.sendMessage("§7Partychat: §2/pc §7<Nachricht>");
            }
        }
    }
}
