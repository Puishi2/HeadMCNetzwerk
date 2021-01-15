package de.headmc.data;

import de.headmc.bungee.Proxy;
import de.headmc.commands.*;
import de.headmc.report.commands.ReportCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.PluginManager;

import java.util.ArrayList;
import java.util.UUID;

public class Data {

    public static final String PROXY_PREFIX = "§8» §l§3Proxy §8│ §7";
    public static ArrayList<UUID> report = new ArrayList<>();

    public void init(){
        PluginManager pluginManager = ProxyServer.getInstance().getPluginManager();

        pluginManager.registerCommand(Proxy.getInstance(), new InfoCommand("info"));
        pluginManager.registerCommand(Proxy.getInstance(), new HelpCommand("help"));
        pluginManager.registerCommand(Proxy.getInstance(), new KickCommand("kick"));
        pluginManager.registerCommand(Proxy.getInstance(), new PingCommand("ping"));
        pluginManager.registerCommand(Proxy.getInstance(), new JoinMeCommand("joinme"));
        pluginManager.registerCommand(Proxy.getInstance(), new ReportCommand("report"));



    }
}
