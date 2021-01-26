package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class KickCommand extends Command {

    public KickCommand(String name) {
        super(name);

    }

    public void execute(CommandSender sender, String[] args) {
        final ProxiedPlayer player = (ProxiedPlayer)sender;
        if (player.hasPermission("headmc.kick")) {
            if (args.length < 2) {
                player.sendMessage(Data.PROXY_PREFIX + "Verwende §a/kick §8(§2Spieler§8) (§2Grund§8)");
            } else {
                if (ProxyServer.getInstance().getPlayer(args[0]) == null) {
                    player.sendMessage(Data.PROXY_PREFIX + "Dieser §2Spieler §7ist nicht Online.");
                    return;
                }
                String message = "";
                int i = 1;
                while (i < args.length) {
                    message = message + args[i] + " ";
                    i++;
                }
                ProxiedPlayer player2 = ProxyServer.getInstance().getPlayer(args[0]);
                String reason = message;
                player.sendMessage(Data.PROXY_PREFIX + "Du hast §2" + player2.getName() + "§7 für §2" + reason + "§7 gekickt.");
                player2.disconnect("§8✗ §3HeadMC.de §8✗ \n\n §7Du wurdest gekickt! \n §7Grund§8: §2" + reason);
                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                    if (!all.hasPermission("headmc.kick"))
                        continue;
                    all.sendMessage(Data.PROXY_PREFIX + "§2"+ player2.getName() + "§7 wurde von §2" + player.getName() + "§7 vom Server gekickt.");
                    all.sendMessage(Data.PROXY_PREFIX + "Grund: §2§l" + message);
                }
            }
        } else {
            sender.sendMessage(Data.PROXY_NOPERMS);
        }
    }
}