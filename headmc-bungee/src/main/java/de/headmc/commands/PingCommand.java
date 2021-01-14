package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

public class PingCommand extends Command {


    public PingCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
    if(!(commandSender instanceof ProxiedPlayer)){
        return;
    }else{

        ProxiedPlayer proxiedPlayer = (ProxiedPlayer)commandSender;
        ProxiedPlayer proxiedTarget = ProxyServer.getInstance().getPlayer(strings[0]);

        if(strings.length ==  0){


            proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Du hast einen Ping von §3" + proxiedPlayer.getPing() +"§7ms.");


        }else if(strings.length ==1) {

            proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Der Spieler §3" + proxiedTarget.getName() +" §7hat einen Ping von §3" + proxiedTarget.getPing() + "§7ms.");

        }

    }


    }
}