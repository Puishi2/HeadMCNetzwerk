package de.headmc.core.manager;

import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.service.ICloudService;
import eu.thesimplecloud.api.servicegroup.ICloudServiceGroup;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PrivateServerManager {

    public void createPrivateServer(Player player, String group){
        ICloudServiceGroup serviceGroup = CloudAPI.getInstance().getCloudServiceGroupManager().getServiceGroupByName(group);
        if (serviceGroup != null) {
            serviceGroup.startNewService().addListener(future -> {
                ICloudService cloudService = (ICloudService) future.getNow();
                ICloudPlayer iCloudPlayer = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(player.getUniqueId());
                iCloudPlayer.connect(cloudService);
            });
        }
    }

}
