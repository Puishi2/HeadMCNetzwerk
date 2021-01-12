package de.headmc.utils;

import de.headmc.core.Core;
import de.headmc.core.api.CoinsAPI;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.event.player.permission.CloudPlayerPermissionCheckEvent;
import eu.thesimplecloud.api.player.CloudPlayer;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.player.SimpleCloudPlayer;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Data {

    public void loadJoinitems(Player player){

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        ItemStack nav = new ItemManager(Material.BOOK).setDisplayName("§8» §bNavigator").toItemStack();

        player.getInventory().setItem(1, nav);
        player.getInventory().setItem(4, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622")).setDisplayName("§8» §3Extras").toItemStack());
        player.getInventory().setItem(7, new ItemManager(Material.REDSTONE_COMPARATOR).setDisplayName("§8» §3Einstellungen").toItemStack());

    }

    public void createScoreboard(HeadMCPlayer headMCPlayer, Player player) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("aaa", "bbb");

        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§8✗ §3HeadMC.de §8✗");

        objective.getScore("§8§m----------------").setScore(13);
        objective.getScore("§3").setScore(12);
        objective.getScore(" §8» §7Rang").setScore(11);
        if(permissionPlayer.hasPermissionGroup("Admin")) {
            objective.getScore("  §8➥ §4Admin").setScore(10);
        } else if(permissionPlayer.hasPermissionGroup("SrDeveloper")) {
            objective.getScore("  §8➥ §bSrDeveloper").setScore(10);
        } else {
            objective.getScore("  §8➥ §aSpieler").setScore(10);
        }
        objective.getScore("§1").setScore(9);
        objective.getScore(" §8» §7Coins").setScore(8);
        objective.getScore(" §8➥ §3" + new CoinsAPI().getCoins(player)).setScore(7);
        objective.getScore("§2").setScore(6);
        objective.getScore(" §8» §7Hoster").setScore(5);
        objective.getScore(" §8➥ §3Venocix.de").setScore(4);
        objective.getScore("§4").setScore(3);
        objective.getScore("§8§m----------------§7").setScore(2);

        player.setScoreboard(scoreboard);

    }

}
