package de.headmc.lobby;

import de.headmc.command.BuildCommand;
import de.headmc.commands.SetupCommand;
import de.headmc.core.Core;
import de.headmc.core.data.Data;
import de.headmc.core.sql.MySQL;
import de.headmc.effects.SpawnParticles;
import de.headmc.listener.CancelledEvents;
import de.headmc.listener.PlayerJoinListener;
import de.headmc.listener.navigator.NavigatorListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    public static Lobby instance;

    private MySQL mySQL;

    @Override
    public void onEnable() {
        instance = this;
        init();

        System.out.println(Data.NETWORK_PREFIX + "Lobby wird gestartet!");
        new SpawnParticles().spawnParticles();

    }

    @Override
    public void onDisable() {

    }
    private void init(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new NavigatorListener(), this);
        pluginManager.registerEvents(new CancelledEvents(), this);
        pluginManager.registerEvents(new BuildCommand(), this);

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("setup").setExecutor(new SetupCommand());

    }

    public static Lobby getInstance() {
        return instance;
    }


}
