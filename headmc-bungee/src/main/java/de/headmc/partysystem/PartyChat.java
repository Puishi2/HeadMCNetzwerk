package de.headmc.partysystem;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * JavaDoc this file!
 * Created: 21.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class PartyChat extends Command {

    public PartyChat() {
        super("pc");
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer)sender;
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
    }
}
