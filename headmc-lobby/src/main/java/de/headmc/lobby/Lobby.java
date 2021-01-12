package de.headmc.lobby;

import de.headmc.core.sql.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    public static Lobby instance;

    private MySQL mySQL;

    @Override
    public void onEnable() {
        instance = this;

    }

    @Override
    public void onDisable() {

    }

    public static Lobby getInstance() {
        return instance;
    }


}
