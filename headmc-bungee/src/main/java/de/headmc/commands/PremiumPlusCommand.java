package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * JavaDoc this file!
 * Created: 19.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class PremiumPlusCommand extends Command {

    public PremiumPlusCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            final ProxiedPlayer player = (ProxiedPlayer) sender;
            if(args.length == 0) {

                player.sendMessage("§8§m--------------------");
                player.sendMessage("§3");
                player.sendMessage("§8➥ §7");
                player.sendMessage("§8➥ §7");
                player.sendMessage("§8➥ §7");
                player.sendMessage("§8➥ §7");
                player.sendMessage("§8➥ §7");
                player.sendMessage("§5");
                player.sendMessage("§8§m--------------------§8§7§5§3§9");

            } else {
                player.sendMessage(Data.PROXY_PREFIX + "Du musst §2/yt §7benutzen, um Informationen über den §2Premium+ Rang §7zu erfahren.");
            }
        }
    }
}

