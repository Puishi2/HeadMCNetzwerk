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

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

        if(!(commandSender instanceof ProxiedPlayer)){
            return;
        }else{
            ProxiedPlayer proxiedPlayer = (ProxiedPlayer)commandSender;
            ProxiedPlayer proxiedtarget = ProxyServer.getInstance().getPlayer(strings[0]);

            if(strings.length == 0) {
                proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cBenutze /kick <Player> <Grund>!");
            } else if(strings.length == 1) {
                proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cBenutze /kick <Player> <Grund>!");
            } else if(strings.length == 2) {

                if(proxiedtarget != null) {

                    if(strings[1].equalsIgnoreCase(strings[1])) {
                        proxiedtarget.disconnect("§8✗ §3HeadMC.de §8✗ \n\n §7Du wurdest gekickt! \n §7Grund§8: §3" + strings[1]);
                        proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Du hast den Spieler §3" + proxiedtarget.getName() + " §7gekickt!");

                    }

                } else {
                    proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cDieser Spieler ist nicht online!");
                }

            } else {
                proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cBenutze /kick <Player> <Grund>!");
            }

        }
    }
}
