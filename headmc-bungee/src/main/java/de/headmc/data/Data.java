package de.headmc.data;

import de.headmc.bungee.Proxy;
import de.headmc.commands.*;
import de.headmc.listener.ChatListener;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.PluginManager;

import java.util.ArrayList;

public class Data {

    public static final String PROXY_PREFIX = "§8» §l§2Proxy §8│ §7";
    public static final String PARTY_PREFIX = "§8» §l§5Party §8│ §7";
    public static final String PROXY_NOPERMS = PROXY_PREFIX + "Dazu hast du keine Rechte!";
    public static ArrayList<CommandSender> teamchat = new ArrayList<>();

    public void init(){
        PluginManager pluginManager = ProxyServer.getInstance().getPluginManager();

        pluginManager.registerListener(Proxy.getInstance(), new ChatListener());
        pluginManager.registerCommand(Proxy.getInstance(), new ServerJoinCommand());
        pluginManager.registerCommand(Proxy.getInstance(), new FindCommand("find"));
        pluginManager.registerCommand(Proxy.getInstance(), new InfoCommand("info"));
        pluginManager.registerCommand(Proxy.getInstance(), new KickCommand("kick"));
        pluginManager.registerCommand(Proxy.getInstance(), new PingCommand("ping"));
        pluginManager.registerCommand(Proxy.getInstance(), new JoinMeCommand("joinme"));
        pluginManager.registerCommand(Proxy.getInstance(), new HelpCommand("help", null, "hilfe"));
        pluginManager.registerCommand(Proxy.getInstance(), new YoutubeCommand("youtube", null, "yt"));
        pluginManager.registerCommand(Proxy.getInstance(), new PremiumPlusCommand("premium+", null, "p+"));
        pluginManager.registerCommand(Proxy.getInstance(), new TeamChatCommand("teamchat", "headmc.team", "tc"));

    }
}
