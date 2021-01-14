package de.headmc.utils;

import de.headmc.core.Core;
import de.headmc.core.api.CoinsAPI;
import de.headmc.core.manager.ActionbarManager;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import de.headmc.lobby.Lobby;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.event.player.permission.CloudPlayerPermissionCheckEvent;
import eu.thesimplecloud.api.player.CloudPlayer;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.player.SimpleCloudPlayer;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import javax.swing.*;
import java.util.ArrayList;

public class Data {

    public static ArrayList<Player> build = new ArrayList<>();
    public static ArrayList<Player> hidePlayer = new ArrayList<>();

    public void loadJoinitems(Player player){

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        ItemStack nav = new ItemManager(Material.BOOK).setDisplayName("§8» §3§LNavigator §8× §7Rechtsclick").toItemStack();

        player.getInventory().setItem(0, nav);
        player.getInventory().setItem(1, new ItemManager(Material.GLOWSTONE_DUST).setDisplayName("§8» §c§lPrivater Server §8× §7Rechtsclick").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
        player.getInventory().setItem(4, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025")).setDisplayName("§8» §cKein Gadget").toItemStack());
        player.getInventory().setItem(7, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622")).setDisplayName("§8» §3§lExtras §8× §7Rechtsclick").toItemStack());
        player.getInventory().setItem(8, new ItemManager(Material.REDSTONE_COMPARATOR).setDisplayName("§8» §3§LEinstellungen §8× §7Rechtsclick").toItemStack());

    }

    public void createScoreboard(HeadMCPlayer headMCPlayer, Player player) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("aaa", "bbb");

        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§8✗ §3§lHeadMC.de §8✗");

        objective.getScore("§8§m----------------").setScore(13);
        objective.getScore("§3").setScore(12);
        objective.getScore(" §8» §7Rang").setScore(11);
        if(permissionPlayer.hasPermissionGroup("Admin")) {
            objective.getScore("  §8➥ §4Admin").setScore(10);
        } else if(permissionPlayer.hasPermissionGroup("SrDeveloper")) {
            objective.getScore("  §8➥ §bSrDeveloper").setScore(10);
        } else if(permissionPlayer.hasPermissionGroup("Developer")){
            objective.getScore("  §8➥ §bDeveloper").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Builder")){
            objective.getScore("  §8➥ §2Builder").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Supporter")){
            objective.getScore("  §8➥ §3Supporter").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Moderator")){
            objective.getScore("  §8➥ §9Moderator").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("SrModerator")){
            objective.getScore("  §8➥ §9SrModerator").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Freund")){
            objective.getScore("  §8➥ §fFreund").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("SrContent")){
            objective.getScore("  §8➥ §cSrContent").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Content")){
            objective.getScore("  §8➥ §cContent").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Prime")){
            objective.getScore("  §8➥ §6Prime").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("YouTuber")){
            objective.getScore("  §8➥ §5YouTuber").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Premium+")){
            objective.getScore("  §8➥ §aPremium§6+").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Head")){
            objective.getScore("  §8➥ §3Head").setScore(10);
        }else {
            objective.getScore("  §8➥ §7Spieler").setScore(10);
        }
        objective.getScore("§1").setScore(9);
        objective.getScore(" §8» §7Coins").setScore(8);
        objective.getScore(" §8➥ §3§l" + new CoinsAPI().getCoinsSpigot(player)).setScore(7);
        objective.getScore("§2").setScore(6);
        objective.getScore(" §8» §7Hoster").setScore(5);
        objective.getScore(" §8➥ §3§lVenocix.de").setScore(4);
        objective.getScore("§4").setScore(3);
        objective.getScore("§8§m----------------§7").setScore(2);

        player.setScoreboard(scoreboard);

    }

    public void sendActionbar(Player player) {

        new BukkitRunnable() {
            @Override
            public void run() {
                ActionbarManager.setActionBar(player, "§8» §7Spielzeit §8× §30 min §8┃ §7Clan §8× §cKein Clan");
            }
        }.runTaskTimer(Lobby.getInstance(), 0, 40);

    }

}
