package de.headmc.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * JavaDoc this file!
 * Created: 26.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class TeamCommand extends Command {

    public TeamCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            File file = new File("plugins//Bungee//config.yml");
            Configuration configuration = null;
            try {
                configuration = YamlConfiguration.getProvider(YamlConfiguration.class).load(file);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            sender.sendMessage("§8§m--------------------");
            sender.sendMessage("§1");
            sender.sendMessage((String) configuration.get("Admin"));
            sender.sendMessage((String) configuration.get("Admin2"));
            sender.sendMessage("§2");
            sender.sendMessage((String) configuration.get("SrDev"));
            sender.sendMessage((String) configuration.get("Dev"));
            sender.sendMessage((String) configuration.get("Dev2"));
            sender.sendMessage("§3");
            sender.sendMessage((String) configuration.get("SrMod"));
            sender.sendMessage((String) configuration.get("Mod"));
            sender.sendMessage("§4");
            sender.sendMessage((String) configuration.get("SrCon"));
            sender.sendMessage((String) configuration.get("Con"));
            sender.sendMessage("§5");
            sender.sendMessage((String) configuration.get("Sup"));
            sender.sendMessage((String) configuration.get("Builder"));
            sender.sendMessage("§6");
            sender.sendMessage("§8§m--------------------§8§7§5§3§9");
        }
    }
}
