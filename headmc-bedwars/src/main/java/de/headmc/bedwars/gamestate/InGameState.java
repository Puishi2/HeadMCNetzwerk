package de.headmc.bedwars.gamestate;

import de.headmc.bedwars.Data;
import org.bukkit.Bukkit;

public class IngameState extends Gamestate{
    @Override
    public void start() {
        Bukkit.broadcastMessage(Data.PREFIX + "Das §c§lSpiel §7beginnt.");
    }

    @Override
    public void stop() {

    }
}
