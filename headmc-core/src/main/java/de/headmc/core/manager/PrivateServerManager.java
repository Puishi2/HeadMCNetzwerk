package de.headmc.core.manager;

import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.servicegroup.ICloudServiceGroup;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PrivateServerManager {

    private static HashMap<Player, String> startedServer = new HashMap<>();

    public void createServer(Player player, String group) {

        ICloudServiceGroup iCloudServiceGroup = CloudAPI.getInstance().getCloudServiceGroupManager().getServiceGroupByName(group);
        iCloudServiceGroup.startNewService();

        startedServer.put(player, group);

    }

}
