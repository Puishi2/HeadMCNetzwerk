package de.headmc.core;

import de.headmc.core.data.Data;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.sql.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static Core instance;

    private Data data;
    private ItemManager itemManager;
    private Base64 base64;

    @Override
    public void onEnable() {
        instance = this;
        this.data = data;
        this.itemManager = itemManager;
        this.base64 = base64;
        new MySQL("localhost", "headmc", "admin", "Minecraft05!");

        System.out.println(data.getNetworkPrefix() + "Core wird gestartet!");

    }

    @Override
    public void onDisable() {

    }

    public static Core getInstance() {
        return instance;
    }

    public Data getData() {
        return data;
    }

    public Base64 getBase64() {
        return base64;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
