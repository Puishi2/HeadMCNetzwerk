package de.headmc.lobby;

import de.headmc.core.Core;
import de.headmc.core.data.Data;
import de.headmc.core.sql.MySQL;
import de.headmc.listener.PlayerJoinListener;
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

    }

    @Override
    public void onDisable() {

    }
    private void init(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this);

    }

    public static Lobby getInstance() {
        return instance;
    }


}
