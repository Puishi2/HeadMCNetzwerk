package de.headmc.skywars;

import de.headmc.skywars.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyWars extends JavaPlugin {

    public static SkyWars instance;

    @Override
    public void onEnable() {
        instance = this;
        register();

    }

    @Override
    public void onDisable() {

    }

    public void register() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new JoinListener(), this);
    }

    public static SkyWars getInstance() {
        return instance;
    }

}
