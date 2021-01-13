package de.headmc.commands;

import de.headmc.core.api.CoinsAPI;
import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class InfoCommand extends Command {
    public InfoCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(!(commandSender instanceof ProxiedPlayer)){
            return;
        }else {
            ProxiedPlayer proxiedPlayer = (ProxiedPlayer)  commandSender;
            ProxiedPlayer proxiedTarget = ProxyServer.getInstance().getPlayer(strings[0]);


            if(proxiedPlayer.hasPermission("headmc.team")){

                if(strings.length == 0){
                    proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Du musst §3/info <PLAYER> §7benutzen, um Informationen von dem Jewaliegen §3Spieler §7zu bekommen.");
                    return;
                }
                if(strings.length == 1){

                   if(proxiedTarget != null){
                       proxiedPlayer.sendMessage("§8§m--------------------");
                       proxiedPlayer.sendMessage("§3");
                       proxiedPlayer.sendMessage("§8➥ §7Name §8× §3" + proxiedTarget.getName());
                       proxiedPlayer.sendMessage("§8➥ §7Server §8× §3" + proxiedTarget.getServer().getInfo());
                       proxiedPlayer.sendMessage("§8➥ §7Coins §8× §3-");
                       proxiedPlayer.sendMessage("§8➥ §7UUID §8× §3" + proxiedTarget.getUniqueId().toString());
                       proxiedPlayer.sendMessage("§8➥ §7OnlineTime §8× §3-");
                       proxiedPlayer.sendMessage("§8➥ §7Banpunkte §8× §3-");
                       proxiedPlayer.sendMessage("§8➥ §7Mutepunkte §8× §3-");
                       proxiedPlayer.sendMessage("§5");
                       proxiedPlayer.sendMessage("§8§m--------------------§8§7§5§3§9");
                   }else {
                       proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Der angegebende §3Spieler §7 ist nicht online.");
                   }

                }

            }


        }


    }


}