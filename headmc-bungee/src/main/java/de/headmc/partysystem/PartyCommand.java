package de.headmc.partysystem;

import net.md_5.bungee.api.CommandSender;
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
                player.sendMessage("§7Partychat: §2/p §7<Nachricht>");
            }
        }
    }
}
