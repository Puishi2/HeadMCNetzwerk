package de.headmc.bedwars.countdown;

import data.Data;
import de.headmc.bedwars.Bedwars;
import de.headmc.bedwars.gamestate.GameState;
import de.headmc.bedwars.gamestate.Lobbystate;
import org.bukkit.Bukkit;

public class LobbyCountdown extends Countdown{

    private final int RESET_SECONDS = 10;
    private final int IDLE_SECONDS = 90;

    private boolean isRunning = false, isIdling = false;
    private int seconds = 15;
    private int idleID;

    @Override
    public void run() {
    isRunning = true;

    taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.getInstance(), new Runnable() {
        @Override
        public void run() {

            switch (seconds){
                case 60: case 30: case 15: case 10: case 5: case 4: case 3: case 2:
                    Bukkit.broadcastMessage(Data.PREFIX + "Das Spiel startet in §c§l" + seconds + "§7Sekunden.");
                    break;

                case 1:
                    Bukkit.broadcastMessage(Data.PREFIX + "Das Spiel startet in §c§leiner §7Sekunde.");
                    break;
                case 0:
                    Bedwars.getInstance().getGameStateManager().setGameStates(GameState.INGAME_STATE);
                    break;

                default:
                    break;
            }

            seconds --;
        }
    }, 0, 20*1);

    }
    public void cancel(){
        isRunning = false;
        Bukkit.getScheduler().cancelTask(taskID);
        seconds = RESET_SECONDS;
    }

    public void idle(){
       idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Bedwars.getInstance(), new Runnable() {
           @Override
           public void run() {
               int missingPlayers = Lobbystate.MIN_PLAYERS - Bedwars.getInstance().getPlayers().size();
               if(missingPlayers != 1)
                   Bukkit.broadcastMessage(Data.PREFIX + "Es fehlen noch §c§l" + missingPlayers + "§7 Spieler.");
               else
                   Bukkit.broadcastMessage(Data.PREFIX + "Es fehlt noch §c§lein §7Spieler.");
           }
       }, IDLE_SECONDS *20, IDLE_SECONDS+ 20);
    }

    public void cancelIdle(){

        Bukkit.getScheduler().cancelTask(idleID);
    }

    public boolean isRunning() {
        return isRunning;
    }


    public boolean isIdling() {
        return isIdling;
    }
}
