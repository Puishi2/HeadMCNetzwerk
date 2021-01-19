package de.headmc.bedwars.gamestate.manager;

import de.headmc.bedwars.gamestate.EndingState;
import de.headmc.bedwars.gamestate.GameState;
import de.headmc.bedwars.gamestate.InGameState;
import de.headmc.bedwars.gamestate.Lobbystate;

public class GameStateManager {

    private GameState[] gameStates = new GameState[3];
    private GameState currentGameState;


    public GameStateManager(){

        gameStates[GameState.LOBBY_STATE] = new Lobbystate();
        gameStates[GameState.INGAME_STATE] = new InGameState();
        gameStates[GameState.ENDING_STATE] = new EndingState();

    }

    public void setGameStates(int gameStateIndex){

        if(currentGameState != null)
            currentGameState.stop();
        currentGameState = gameStates[gameStateIndex];
        currentGameState.start();

    }

    public void stopCurrentGameState(){
        currentGameState.stop();
        currentGameState = null;
    }

    public GameState[] getGameStates() {
        return gameStates;
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }
}
