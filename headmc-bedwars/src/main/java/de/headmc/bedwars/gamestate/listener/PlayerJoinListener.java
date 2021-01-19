package de.headmc.bedwars.gamestate.listener;

import data.Data;
import de.headmc.bedwars.Bedwars;
import de.headmc.bedwars.gamestate.Lobbystate;
import de.headmc.bedwars.gamestate.manager.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {

    private GameStateManager gameStateManager;

    public PlayerJoinListener(GameStateManager gameStateManager){
        this.gameStateManager = gameStateManager;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event){
        Player player = event.getPlayer();
        Lobbystate lobbystate = (Lobbystate) gameStateManager.getCurrentGameState();
        Bedwars.getInstance().getPlayers().add(player);
        event.setJoinMessage(Data.PREFIX + "Der Spieler §c§l" + player.getName()
         + "§7 hat das Spiel betreten. §8[§c§l" + Bedwars.getInstance().getPlayers().size() + "§8/§c§l" + Lobbystate.MAX_PLAYERS + "§8]");

        if(Bedwars.getInstance().getPlayers().size() >= Lobbystate.MIN_PLAYERS){
            if(!lobbystate.getLobbyCountdown().isRunning()){
                if(lobbystate.getLobbyCountdown().isIdling())
                    lobbystate.getLobbyCountdown().cancelIdle();
                lobbystate.getLobbyCountdown().run();
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event){
        Player player = event.getPlayer();
        Bedwars.getInstance().getPlayers().remove(player);
        event.setQuitMessage(Data.PREFIX + "Der Spieler §c§l" + player.getName() + "§7hat das Spiel verlassen.");
        Lobbystate lobbystate = (Lobbystate) gameStateManager.getCurrentGameState();

        if(Bedwars.getInstance().getPlayers().size() < Lobbystate.MIN_PLAYERS){
            if(lobbystate.getLobbyCountdown().isRunning()){
                lobbystate.getLobbyCountdown().cancel();
                if(!lobbystate.getLobbyCountdown().isIdling())
                    lobbystate.getLobbyCountdown().idle();
            }

        }

    }

}
