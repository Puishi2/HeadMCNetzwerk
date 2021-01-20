package de.headmc.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * JavaDoc this file!
 * Created: 20.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class ServerJoinCommand extends Command {

    public ServerJoinCommand() {
        super("abcdefghijk");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 1) {
            String server  = args[0];
            final ProxiedPlayer player = (ProxiedPlayer) sender;
            ServerInfo serverInfo = ProxyServer.getInstance().getServerInfo(server);
            player.connect(serverInfo);
        }
    }
}
