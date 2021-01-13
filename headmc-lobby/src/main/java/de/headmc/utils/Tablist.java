package de.headmc.utils;

import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.group.PermissionGroup;
import eu.thesimplecloud.module.permission.group.manager.PermissionGroupManager;
import eu.thesimplecloud.module.permission.permission.Permission;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import eu.thesimplecloud.plugin.proxy.bungee.CloudBungeePlugin;
import eu.thesimplecloud.plugin.startup.CloudPlugin;
import org.bukkit.entity.Player;

public class Tablist {

    public void test(Player palyer) {

        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId().toString());

    }

}
