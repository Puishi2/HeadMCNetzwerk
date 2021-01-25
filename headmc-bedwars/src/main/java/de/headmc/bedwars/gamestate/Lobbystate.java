package de.headmc.bedwars.gamestate;

import de.headmc.bedwars.countdown.lobbycountdown.LobbyCountdown;
import de.headmc.bedwars.manager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Lobbystate extends Gamestate{

    public static final int MIN_PLAYERS = 2,
                            MAX_PLAYERS = 2;

    private LobbyCountdown lobbyCountdown;


    @Override
    public void start() {



        lobbyCountdown = new LobbyCountdown();
        lobbyCountdown.idle();

    }

    @Override
    public void stop() {

    }

    public LobbyCountdown getLobbyCountdown() {
        return lobbyCountdown;
    }
}
