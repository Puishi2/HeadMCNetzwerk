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
            sender.sendMessage("§4Admin §8➥ §4" + configuration.get("Admin"));
            sender.sendMessage("§4Admin §8➥ §4" + configuration.get("Admin2"));
            sender.sendMessage("§2");

            if(configuration.get("SrDev") != null) {
                sender.sendMessage("§bSrDev §8➥ §b" + configuration.get("SrDev"));
            } else {
                sender.sendMessage("§bSrDev §8➥ §7wird gesucht!");
            }

            if(configuration.get("Dev") != null) {
                sender.sendMessage("§bDev §8➥ §b" + configuration.get("Dev"));
            } else {
                sender.sendMessage("§bDev §8➥ §7wird gesucht!");
            }

            if(configuration.get("Dev2") != null) {
                sender.sendMessage("§bDev §8➥ §b" + configuration.get("Dev2"));
            } else {
                sender.sendMessage("§bDev §8➥ §7wird gesucht!");
            }

            sender.sendMessage("§3");

            if(configuration.get("SrCon") != null) {
                sender.sendMessage("§cSrCon §8➥ §c" + configuration.get("SrCon"));
            } else {
                sender.sendMessage("§cSrCon §8➥ §7wird gesucht!");
            }

            if(configuration.get("Con") != null) {
                sender.sendMessage("§cCon §8➥ §c" + configuration.get("Con"));
            } else {
                sender.sendMessage("§cCon §8➥ §7wird gesucht!");
            }

            if(configuration.get("Con2") != null) {
                sender.sendMessage("§cCon §8➥ §c" + configuration.get("Con2"));
            }

            sender.sendMessage("§4");

            if(configuration.get("SrMod") != null) {
                sender.sendMessage("§9SrMod §8➥ §9" + configuration.get("SrMod"));
            } else {
                sender.sendMessage("§9SrMod §8➥ §7wird gesucht!");
            }

            if(configuration.get("Mod") != null) {
                sender.sendMessage("§9Mod §8➥ §9" + configuration.get("Mod"));
            } else {
                sender.sendMessage("§9Mod §8➥ §7wird gesucht!");
            }

            if(configuration.get("Mod2") != null) {
                sender.sendMessage("§9Mod §8➥ §9" + configuration.get("Mod2"));
            } else {
                sender.sendMessage("§9Mod §8➥ §7wird gesucht!");
            }

            sender.sendMessage("§5");

            if(configuration.get("Sup") != null) {
                sender.sendMessage("§aSup §8➥ §a" + configuration.get("Sup"));
            } else {
                sender.sendMessage("§aSup §8➥ §7wird gesucht!");
            }

            if(configuration.get("Sup2") != null) {
                sender.sendMessage("§aSup §8➥ §a" + configuration.get("Sup2"));
            } else {
                sender.sendMessage("§aSup §8➥ §7wird gesucht!");
            }

            if(configuration.get("Sup3") != null) {
                sender.sendMessage("§aSup §8➥ §a" + configuration.get("Sup3"));
            }

            if(configuration.get("Sup4") != null) {
                sender.sendMessage("§aSup §8➥ §a" + configuration.get("Sup4"));
            }

            sender.sendMessage("§6");

            if(configuration.get("Builder") != null) {
                sender.sendMessage("§2Builder §8➥ §2" + configuration.get("Builder"));
            } else {
                sender.sendMessage("§2Builder §8➥ §7wird gesucht!");
            }

            if(configuration.get("Builder2") != null) {
                sender.sendMessage("§2Builder §8➥ §2" + configuration.get("Builder2"));
            } else {
                sender.sendMessage("§2Builder §8➥ §7wird gesucht!");
            }

            sender.sendMessage("§7");
            sender.sendMessage("§8§m--------------------§8§7§5§3§9");
        }
    }
}
