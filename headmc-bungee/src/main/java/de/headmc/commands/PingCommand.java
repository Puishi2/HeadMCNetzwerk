package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {

        final ProxiedPlayer proxiedPlayer = (ProxiedPlayer) commandSender;

        if(args.length == 0) {
            proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Dein Ping beträgt §2§l" + proxiedPlayer.getPing() + "§7ms.");
        } else if (args.length == 1) {
            final ProxiedPlayer targetPlayer = ProxyServer.getInstance().getPlayer(args[0]);
            targetPlayer.sendMessage(Data.PROXY_PREFIX + "Dein Ping beträgt §2§l" + targetPlayer.getPing() + "§7ms.");
        }
    }
}
