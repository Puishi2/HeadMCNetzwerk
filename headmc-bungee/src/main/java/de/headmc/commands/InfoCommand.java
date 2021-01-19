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

                if(strings.length == 0) {
                    proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cBenutze /info <Player>!");
                } else if(strings.length == 1) {

                    if(proxiedTarget != null){
                        proxiedPlayer.sendMessage("§8§m--------------------");
                        proxiedPlayer.sendMessage("§3");
                        proxiedPlayer.sendMessage("§8➥ §7Name §8× §2" + proxiedTarget.getName());
                        proxiedPlayer.sendMessage("§8➥ §7Server §8× §2" + proxiedTarget.getServer().getInfo().getName());
                        proxiedPlayer.sendMessage("§8➥ §7Coins §8× §20");
                        proxiedPlayer.sendMessage("§8➥ §7UUID §8× §2" + proxiedTarget.getUniqueId().toString());
                        proxiedPlayer.sendMessage("§8➥ §7OnlineTime §8× §20 min");
                        proxiedPlayer.sendMessage("§8➥ §7Banpunkte §8× §20");
                        proxiedPlayer.sendMessage("§8➥ §7Mutepunkte §8× §20");
                        proxiedPlayer.sendMessage("§5");
                        proxiedPlayer.sendMessage("§8§m--------------------§8§7§5§3§9");
                    }else {
                        proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cDer angegebende §3Spieler §7 ist nicht online.");
                    }

                } else {
                    proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "§cBenutze /info <Player>!");
                }

            } else {
                proxiedPlayer.sendMessage(Data.PROXY_NOPERMS);
            }


        }


    }


}
