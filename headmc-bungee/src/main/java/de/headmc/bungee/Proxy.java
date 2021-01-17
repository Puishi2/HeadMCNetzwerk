package de.headmc.bungee;


import de.headmc.bansystem.BanCategroy;
import de.headmc.core.sql.MySQL;
import de.headmc.data.Data;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.HashMap;

public class Proxy extends Plugin {


    private static Proxy instance;
    public static HashMap<String, BanCategroy> banCategroy;


    @Override
    public void onEnable() {

        new Data().init();
        instance = this;
        System.out.println(Data.PROXY_PREFIX + "Das PLugin wurde erfolgreich aktiviert.");
        new MySQL("localhost", "headmc", "admin", "Minecraft05!");
        banCategroy = new HashMap<>();

        new BanCategroy("Hacking", 30);
        new BanCategroy("Teaming", 7);
        new BanCategroy("Hausverbot", -1);
        new BanCategroy("Skin / Name", 10);
        new BanCategroy("Rassismuss", -1);


    }

    @Override
    public void onDisable() {
        System.out.println(Data.PROXY_PREFIX + "Das PLugin wurde erfolgreich deaktiviert.");

    }



    public static Proxy getInstance() {
        return instance;
    }



}
