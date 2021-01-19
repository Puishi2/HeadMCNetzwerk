package de.headmc.bedwars.gamestate;

import de.headmc.bedwars.countdown.LobbyCountdown;

public class Lobbystate extends GameState{

    public  static final int MAX_PLAYERS = 2;
    public static final int MIN_PLAYERS = 2;

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
