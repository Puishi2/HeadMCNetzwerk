package de.headmc.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

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
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
            sender.sendMessage((String) configuration.get("Admin"));
            sender.sendMessage((String) configuration.get("Admin2"));
            sender.sendMessage((String) configuration.get("Dev"));
        }
    }
}
