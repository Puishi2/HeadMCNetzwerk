package de.headmc.bungee;


import de.headmc.core.sql.MySQL;
import de.headmc.data.Data;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.HashMap;

public class Proxy extends Plugin {

    private static Proxy instance;

    @Override
    public void onEnable() {

        new Data().init();
        new Data().readFile();
        instance = this;
        System.out.println(Data.PROXY_PREFIX + "Das Plugin wurde erfolgreich aktiviert.");
        //new MySQL("localhost", "headmc", "admin", "UAKmN2B2OAPNTkVhjCBJ");

    }

    @Override
    public void onDisable() {
        System.out.println(Data.PROXY_PREFIX + "Das Plugin wurde erfolgreich deaktiviert.");

    }

    public static Proxy getInstance() {
        return instance;
    }

}
