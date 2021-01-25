package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * JavaDoc this file!
 * Created: 19.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class TeamChatCommand extends Command {

    public TeamChatCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    public void execute(CommandSender sender, String[] args) {

        final ProxiedPlayer player = (ProxiedPlayer) sender;

        if (!(player.hasPermission("headmc.team"))) {
            player.sendMessage(Data.PROXY_NOPERMS);
        }

        if (args.length == 0) {

            player.sendMessage(Data.PROXY_PREFIX + "Verwende §2/tc <message>§7, um eine Nachticht an alle Teamler zu senden.");

        /*} if(args.length == 1) {

            if(args[0].equals("login")) {
                player.sendMessage(Data.PROXY_PREFIX + "Du hast dich erfolgreich §7in den Teamchat §2eingeloggt§7.");
                Data.teamchat.add(player);
            } else if(args[0].equals("logout")) {
                player.sendMessage(Data.PROXY_PREFIX + "Du hast dich erfolgreich §7in den Teamchat §causgeloggt§7.");
                Data.teamchat.remove(player);
            }

        }*/
            if (Data.teamchat.contains(player)) {
                String message = " ";
                Integer count = Integer.valueOf(0);
                while (count.intValue() < args.length) {
                    message = String.valueOf(message) + " " + args[count.intValue()];
                    count = Integer.valueOf(count.intValue() + 1);
                }
                message = Data.PROXY_PREFIX + player.getName() + "§8 » §2" + message;
                for (ProxiedPlayer proxiedPlayer : ProxyServer.getInstance().getPlayers()) {
                    if (!(player.hasPermission("headmc.team"))) {
                        continue;
                    }
                    proxiedPlayer.sendMessage(message);
                }
            }
        }
    }
}