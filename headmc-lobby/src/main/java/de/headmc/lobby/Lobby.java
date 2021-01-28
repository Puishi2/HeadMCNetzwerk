package de.headmc.lobby;

import de.headmc.commands.*;
import de.headmc.core.data.Data;
import de.headmc.core.effects.ParticleManager;
import de.headmc.core.manager.ArmorStandManager;
import de.headmc.core.manager.Base64;
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
import de.headmc.listener.lottery.LotteryListenner;
import de.headmc.privateserver.PrivateServerListener;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class Lobby extends JavaPlugin {


    public static Lobby instance;

    private MySQL mySQL;

    static double i = 0;

    @Override
    public void onEnable() {
        instance = this;
        init();

        System.out.println(Data.NETWORK_PREFIX + "Lobby wird gestartet!");

        new SpawnParticles().spawnParticles();

        new MySQL("localhost", "headmc", "admin", "UAKmN2B2OAPNTkVhjCBJ");
        new de.headmc.utils.Data().updateScoreboard();
        spawnArmorstands();

    }

    @Override
    public void onDisable() {

    }

    /**
     * Test
     */

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
        pluginManager.registerEvents(new PrivateServerListener(), this);
        pluginManager.registerEvents(new LotteryListenner(), this);

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("setup").setExecutor(new SetupCommand());
        getCommand("addcoins").setExecutor(new AddCoinsCommand());
        getCommand("removecoins").setExecutor(new RemoveCoinsCommand());
        getCommand("setcoins").setExecutor(new SetCoinsCommand());

    }

    private void spawnArmorstands() {
        Location location = new Location(Bukkit.getWorld("world"), -154.44, 21.5, 144.36, 225, 0);
        ArmorStand armorStand = new ArmorStandManager().spawnArmorstand(location, "§6§lCase Opening", Base64.getSkull("http://textures.minecraft.net/texture/f37cae5c51eb1558ea828f58e0dff8e6b7b0b1a183d737eecf714661761"), false, true, false, false);

        Location location1 = new Location(Bukkit.getWorld("world"), -145.58, 21.5, 148.42, 180, 0);
        ArmorStand armorStand1 = new ArmorStandManager().spawnArmorstand(location1, "§5§lLottery", Base64.getSkull("http://textures.minecraft.net/texture/945f47feb4d75cb333914bfdb999a489c9d0e320d548f310419ad738d1e24b9"), false, true, false, false);

        new BukkitRunnable() {
            @Override
            public void run() {
                Location location2 = new Location(Bukkit.getWorld("world"), -154.44, 22, 144.36, 225, 0);
                new ParticleManager().spawnParticle(location2, Effect.LAVA_POP);
            }
        }.runTaskTimer(Lobby.getInstance(), 0, 20);

        new BukkitRunnable() {
            @Override
            public void run() {
                Location location3 = new Location(Bukkit.getWorld("world"), -145.58, 22, 148.42, 180, 0);
                new ParticleManager().spawnParticle(location3, Effect.LAVA_POP);
            }
        }.runTaskTimer(Lobby.getInstance(), 0, 20);

    }

    public static Lobby getInstance() {
        return instance;
    }


}