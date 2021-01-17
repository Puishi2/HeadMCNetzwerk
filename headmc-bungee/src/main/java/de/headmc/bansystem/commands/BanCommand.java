package de.headmc.bansystem.commands;

import de.headmc.bansystem.BanCategroy;
import de.headmc.bungee.Proxy;
import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.bukkit.entity.Player;

public class BanCommand extends Command {

    private Proxy proxy;
    private BanCategroy banCategroy;

    public BanCommand(String name, Proxy proxy) {
        super(name);

    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof ProxiedPlayer){

            ProxiedPlayer player = (ProxiedPlayer) commandSender;

            if(player.hasPermission("headmc.ban")){

                if(strings.length == 1){

                    if(strings[0].equalsIgnoreCase("help")){

                        if(Proxy.banCategroy.isEmpty()){
                            player.sendMessage(Data.PROXY_PREFIX + "Es wurden noch keine Ban Gründe konfiguriert.");

                        return;
                        }
                        player.sendMessage(Data.PROXY_PREFIX + "Folgenede Kategorien stehen zu Auswahl: ");
                        Proxy.banCategroy.forEach((s, banCategroy) ->{
                            player.sendMessage(Data.PROXY_PREFIX + banCategroy.getName().toUpperCase());
                        });
                        return;
                    }
                }

            }

        }


    }

    public Proxy getProxy() {
        return proxy;
    }
}
