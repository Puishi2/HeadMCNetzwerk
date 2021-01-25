package de.headmc.bedwars;

import de.headmc.bedwars.gamestate.Gamestate;
import de.headmc.bedwars.gamestate.manager.GamestateManager;
import de.headmc.bedwars.items.listener.LeaveItem;
import de.headmc.bedwars.items.listener.PerksItem;
import de.headmc.bedwars.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class BedWars extends JavaPlugin {

    private ArrayList<Player> players;
    private static BedWars instance;
    private GamestateManager gamestateManager;

    @Override
    public void onEnable() {
        instance = this;
        init();
        gamestateManager = new GamestateManager();
        gamestateManager.setGameState(Gamestate.LOBBY_STATE);
        players = new ArrayList<>();
    }

    private void init() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinListener(gamestateManager), this);
        pm.registerEvents(new LeaveItem(), this);
        pm.registerEvents(new PerksItem(), this);
    }

    @Override
    public void onDisable() {


    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public GamestateManager getGamestateManager() {
        return gamestateManager;
    }

    public static BedWars getInstance() {
        return instance;
    }
}
