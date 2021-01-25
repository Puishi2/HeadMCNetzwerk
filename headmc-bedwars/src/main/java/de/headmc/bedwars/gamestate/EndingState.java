package de.headmc.bedwars.gamestate;

import de.headmc.bedwars.Data;
import org.bukkit.Bukkit;

public class EndingState extends Gamestate{

    @Override
    public void start() {
        Bukkit.broadcastMessage(Data.PREFIX + "Der Countdown ist beendet!");
    }

    @Override
    public void stop() {

    }
}
