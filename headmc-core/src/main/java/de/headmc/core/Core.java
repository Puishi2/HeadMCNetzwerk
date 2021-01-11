package de.headmc.core;

import de.headmc.core.sql.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static Core instance;

    @Override
    public void onEnable() {
        instance = this;

        new MySQL("localhost", "headmc", "admin", "Minecraft05!");

    }

    @Override
    public void onDisable() {

    }

    public static Core getInstance() {
        return instance;
    }

}
