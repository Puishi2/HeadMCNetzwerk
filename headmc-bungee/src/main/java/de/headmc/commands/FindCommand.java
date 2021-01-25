package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FindCommand extends Command {


    public FindCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

        if(commandSender instanceof ProxiedPlayer) {

        if(strings.length == 0){

        }else{

            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(strings[0]);

            if(player.hasPermission("headmc.team")){

                if(strings.length == 1){

                    if(target != null){

                        player.sendMessage(Data.PROXY_PREFIX + "Der Spieler §2" + target.getName()+ "§7 befindet sich auf §2" + target.getServer().getInfo().getName() + "§7.");

                    }else{

                        player.sendMessage(Data.PROXY_PREFIX + "Der angegebende §2Spieler §7ist nicht online.");

                        }
                    }
                }
            }
        }
    }
}
