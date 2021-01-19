package de.headmc.bedwars;

import data.Data;
import de.headmc.bedwars.gamestate.GameState;
import de.headmc.bedwars.gamestate.listener.PlayerJoinListener;
import de.headmc.bedwars.gamestate.manager.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;

public class Bedwars extends JavaPlugin {

    private static Bedwars instance;
    private GameStateManager gameStateManager;
    private ArrayList<Player> players;

    @Override
    public void onEnable() {
        instance = this;
        gameStateManager = new GameStateManager();
        players = new ArrayList<>();
       init();
        gameStateManager.setGameStates(GameState.LOBBY_STATE);
        Bukkit.getConsoleSender().sendMessage("Das Plugin wurde erfolgreich akiviert...");
    }
    private void init(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new PlayerJoinListener(gameStateManager), Bedwars.getInstance());
    }
    @Override
    public void onDisable() {



    }


    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static Bedwars getInstance() {
        return instance;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
