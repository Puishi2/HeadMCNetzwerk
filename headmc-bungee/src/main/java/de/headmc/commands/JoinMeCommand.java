package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class JoinMeCommand extends Command {
    public JoinMeCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
    if(!(commandSender instanceof ProxiedPlayer)){
        return;
    }else{

        if(strings.length == 0){

            ProxiedPlayer player = (ProxiedPlayer)commandSender;

            player.sendMessage(Data.PROXY_PREFIX + "Du hast den §3JoinME§7 erfolgreich gesendet.");



            ProxyServer.getInstance().broadcast("§8§m------------------");
            ProxyServer.getInstance().broadcast("§3");
            ProxyServer.getInstance().broadcast("§7Der Spieler §3" + player.getName() + "§7 Spielt auf §3" + player.getServer().getInfo());
            ProxyServer.getInstance().broadcast("§c§l CLICK HIER");
            ProxyServer.getInstance().broadcast("§4");
            ProxyServer.getInstance().broadcast("§8§m------------------§7");

        }else{
            return;
        }

    }


    }
}
