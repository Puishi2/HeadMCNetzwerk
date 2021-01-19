package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HelpCommand extends Command {

    public HelpCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

        if(!(commandSender instanceof ProxiedPlayer)){
            return;
        }else{

            ProxiedPlayer player = (ProxiedPlayer) commandSender;

            if(strings.length == 0) {

                player.sendMessage("§8§m--------------------");
                player.sendMessage("§3");
                player.sendMessage("§8➥ §7Teamspeak §8× §2HeadMC.de");
                player.sendMessage("§8➥ §7Forum §8× §2Heamc.de");
                player.sendMessage("§8➥ §7Discord §8× §2CBzShQRdHp");
                player.sendMessage("§8➥ §7Youtuber ? §8× §6/yt");
                player.sendMessage("§8➥ §7Premium+ ? §8× §6/p+");
                player.sendMessage("§5");
                player.sendMessage("§8§m--------------------§8§7§5§3§9");

            } else {

                player.sendMessage(Data.PROXY_PREFIX + "Du musst §3/help §7benutzen, um Informationen über das §3Netzwerk §7zu erfahren.");

            }

        }

    }
}
