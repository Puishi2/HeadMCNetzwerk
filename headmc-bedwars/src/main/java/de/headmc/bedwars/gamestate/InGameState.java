package de.headmc.bedwars.gamestate;

import data.Data;
import org.bukkit.Bukkit;

public class InGameState extends GameState{
    @Override
    public void start() {
        Bukkit.broadcastMessage(Data.PREFIX + "Das §c§lSpiel §7beginnt.");
    }

    @Override
    public void stop() {

    }
}
