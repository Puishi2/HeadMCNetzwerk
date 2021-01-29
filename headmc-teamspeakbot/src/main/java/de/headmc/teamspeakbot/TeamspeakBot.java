package de.headmc.teamspeakbot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventType;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import net.md_5.bungee.api.plugin.Plugin;

public class TeamspeakBot extends Plugin {

    private static TeamspeakBot instance;

    private TS3Query ts3Query;
    private TS3Config ts3Config;
    private TS3Api ts3Api;

    @Override
    public void onEnable() {
        instance = this;
        init();
    }

    @Override
    public void onDisable() {

    }

    public void init() {

        this.ts3Config = new TS3Config();
        this.ts3Config.setHost("37.114.60.176");
        this.ts3Config.setFloodRate(TS3Query.FloodRate.DEFAULT);

        this.ts3Query = new TS3Query(this.ts3Config);
        this.ts3Query.connect();

        this.ts3Api = this.ts3Query.getApi();
        this.ts3Api.login("serveradmin", "3SRz8fuagV9UFv0H3BkD");
        this.ts3Api.selectVirtualServerById(1);
        this.ts3Api.setNickname("HeadMC | Query");

        register();

    }

    public static TeamspeakBot getInstance() {
        return instance;
    }

    public TS3Config getTs3Config() {
        return ts3Config;
    }

    public TS3Query getTs3Query() {
        return ts3Query;
    }

    public TS3Api getTs3Api() {
        return ts3Api;
    }

    private void register() {
        getTs3Api().registerEvent(TS3EventType.SERVER, 0);
        getTs3Api().addTS3Listeners(new TS3EventAdapter() {
            @Override
            public void onClientJoin(ClientJoinEvent event) {
                int clientId = event.getClientId();
                Client client = getTs3Api().getClientInfo(clientId);

                getTs3Api().sendPrivateMessage(clientId, "Willkommen auf dem HeadMC.de Teamspeak, " + client.getNickname() + ".");
            }
        });
    }

}
