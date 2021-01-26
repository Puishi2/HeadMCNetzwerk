package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * JavaDoc this file!
 * Created: 26.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class BroadCastCommand extends Command {

    public BroadCastCommand(String name) {
        super(name);
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("headmc.broadcast")) {
            if (args.length == 0) {
                sender.sendMessage(Data.PROXY_PREFIX + "Verwende §2/Broadcast §8(§2Nachricht§8)");
            } else if (args.length >= 1) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (i < args.length) {
                    sb.append(String.valueOf(String.valueOf(args[i])) + " ");
                    i++;
                }
                String st = sb.toString();
                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                    all.sendMessage("");
                    all.sendMessage(Data.PROXY_PREFIX + st.replace("&", "§"));
                    all.sendMessage("");
                }
            }
        } else {
            sender.sendMessage(Data.PROXY_NOPERMS);
        }
    }
}
