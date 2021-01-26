package de.headmc.data;

import de.headmc.bungee.Proxy;
import de.headmc.commands.*;
import de.headmc.partysystem.PartyChat;
import de.headmc.partysystem.PartyCommand;
import de.headmc.partysystem.PartyListener;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.PluginManager;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Data {

    public static final String PROXY_PREFIX = "§8» §l§2Proxy §8│ §7";
    public static final String PARTY_PREFIX = "§8» §l§5Party §8│ §7";
    public static final String PROXY_NOPERMS = PROXY_PREFIX + "Dazu hast du keine Rechte!";
    public static ArrayList<CommandSender> teamchat = new ArrayList<>();

    public void createFile() {
        File file = new File("plugins//Bungee//config.yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

        configuration.set("Admin", "§4Admin §8: §4Puishi");
        configuration.set("Admin2", "§4Admin §8: §4HttpEndrew");

        configuration.set("Dev", "§bDev §8: §bPhexxo");

        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        PluginManager pluginManager = ProxyServer.getInstance().getPluginManager();

        pluginManager.registerListener(Proxy.getInstance(), new PartyListener());

        pluginManager.registerCommand(Proxy.getInstance(), new PartyChat());
        pluginManager.registerCommand(Proxy.getInstance(), new PartyCommand());
        pluginManager.registerCommand(Proxy.getInstance(), new ServerJoinCommand());
        pluginManager.registerCommand(Proxy.getInstance(), new TeamCommand("team"));
        pluginManager.registerCommand(Proxy.getInstance(), new FindCommand("find"));
        pluginManager.registerCommand(Proxy.getInstance(), new InfoCommand("info"));
        pluginManager.registerCommand(Proxy.getInstance(), new KickCommand("kick"));
        pluginManager.registerCommand(Proxy.getInstance(), new PingCommand("ping"));
        pluginManager.registerCommand(Proxy.getInstance(), new JoinMeCommand("joinme"));
        pluginManager.registerCommand(Proxy.getInstance(), new BroadCastCommand("broadcast"));
        pluginManager.registerCommand(Proxy.getInstance(), new HelpCommand("help", null, "hilfe"));
        pluginManager.registerCommand(Proxy.getInstance(), new YoutubeCommand("youtube", null, "yt"));
        pluginManager.registerCommand(Proxy.getInstance(), new PremiumPlusCommand("premium+", null, "p+"));
        pluginManager.registerCommand(Proxy.getInstance(), new TeamChatCommand("teamchat", null, "tc"));

    }
}
