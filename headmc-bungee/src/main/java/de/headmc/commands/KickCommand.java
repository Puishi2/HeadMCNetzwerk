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

            if(strings.length == 0){
                return;
            }else{

              if(proxiedtarget != null){

                  if(strings[1].equalsIgnoreCase(strings[1])){

                      proxiedtarget.disconnect("§7Du wurdest vom §3Netzwerk §7gekick.               §7Grund §8» §3" + strings[1]);


                  }

              }else{
                  proxiedPlayer.sendMessage(Data.PROXY_PREFIX + "Der Spieler ist nicht online");
              }

            }

        }
    }
}
