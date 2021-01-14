package de.headmc.data;

import de.headmc.bungee.Proxy;
import de.headmc.commands.HelpCommand;
import de.headmc.commands.InfoCommand;
import de.headmc.commands.KickCommand;
import de.headmc.commands.PingCommand;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.protocol.AbstractPacketHandler;
import net.md_5.bungee.protocol.packet.Kick;

public class Data {

    public static final String PROXY_PREFIX = "§8» §l§3Proxy §8│ §7";


    public void init(){
        PluginManager pluginManager = ProxyServer.getInstance().getPluginManager();

        pluginManager.registerCommand(Proxy.getInstance(), new InfoCommand("info"));
        pluginManager.registerCommand(Proxy.getInstance(), new HelpCommand("help"));
        pluginManager.registerCommand(Proxy.getInstance(), new KickCommand("kick"));
        pluginManager.registerCommand(Proxy.getInstance(), new PingCommand("ping"));


    }
}
