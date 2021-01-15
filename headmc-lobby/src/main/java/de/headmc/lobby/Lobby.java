package de.headmc.lobby;

import de.headmc.commands.BuildCommand;
import de.headmc.commands.SetupCommand;
import de.headmc.core.data.Data;
import de.headmc.core.sql.MySQL;
import de.headmc.effects.SpawnParticles;
import de.headmc.listener.CancelledEvents;
import de.headmc.listener.HotbarSounds;
import de.headmc.listener.PlayerJoinListener;
import de.headmc.listener.lobbyitems.ExtraListener;
import de.headmc.listener.lobbyitems.NavigatorListener;
import de.headmc.listener.lobbyitems.SettingsListener;
import de.headmc.listener.lobbyitems.gadgets.Booster;
import de.headmc.listener.lobbyitems.gadgets.Enderperle;
import de.headmc.listener.lobbyitems.gadgets.Enterhaken;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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

        new MySQL("localhost", "headmc", "admin", "Minecraft05!");

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
        pluginManager.registerEvents(new ExtraListener(), this);
        pluginManager.registerEvents(new Enterhaken(), this);
        pluginManager.registerEvents(new SettingsListener(), this);
        pluginManager.registerEvents(new HotbarSounds(), this);
        pluginManager.registerEvents(new Enderperle(), this);
        pluginManager.registerEvents(new Booster(), this);

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("setup").setExecutor(new SetupCommand());

    }

    public static Lobby getInstance() {
        return instance;
    }


}
