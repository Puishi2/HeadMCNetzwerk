package de.headmc.bungee;


import de.headmc.data.Data;
import net.md_5.bungee.api.plugin.Plugin;

public class Proxy extends Plugin {

    private static Proxy instance;

    @Override
    public void onEnable() {
        new Data().init();
        instance = this;
        System.out.println(Data.PROXY_PREFIX + "Das PLugin wurde erfolgreich aktiviert.");
    }

    @Override
    public void onDisable() {
        System.out.println(Data.PROXY_PREFIX + "Das PLugin wurde erfolgreich deaktiviert.");

    }



    public static Proxy getInstance() {
        return instance;
    }
}
