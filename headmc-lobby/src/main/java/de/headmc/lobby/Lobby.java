package de.headmc.lobby;

import de.headmc.core.Core;
import de.headmc.core.data.Data;
import de.headmc.core.sql.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Lobby extends JavaPlugin {

    public static Lobby instance;

    private MySQL mySQL;

    @Override
    public void onEnable() {
        instance = this;
        init();

        System.out.println(Core.getInstance().getData().getNetworkPrefix() + "Lobby wird gestartet!");

    }

    @Override
    public void onDisable() {

    }
    private void init(){


    }

    public static Lobby getInstance() {
        return instance;
    }


}
