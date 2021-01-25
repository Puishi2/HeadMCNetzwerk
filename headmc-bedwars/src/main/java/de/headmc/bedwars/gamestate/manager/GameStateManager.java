package de.headmc.bedwars.gamestate.manager;

import de.headmc.bedwars.gamestate.EndingState;
import de.headmc.bedwars.gamestate.Gamestate;
import de.headmc.bedwars.gamestate.IngameState;
import de.headmc.bedwars.gamestate.Lobbystate;
import de.headmc.bedwars.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GamestateManager {

    private Gamestate[] gameStates = new Gamestate[3];
    private Gamestate currentGameState;

    public GamestateManager(){
        gameStates[Gamestate.LOBBY_STATE] = new Lobbystate();
        gameStates[Gamestate.INGAME_STATE] = new IngameState();
        gameStates[Gamestate.ENDING_STATE] = new EndingState();
    }

    public void setGameState(int gameStateIndex){
        if(currentGameState != null)
            currentGameState.stop();
        currentGameState = gameStates[gameStateIndex];
        currentGameState.start();
    }

    public void stopCurrentGameState(){

        currentGameState.stop();
        currentGameState = null;
    }


    public Gamestate getCurrentGameState() {
        return currentGameState;
    }
}
