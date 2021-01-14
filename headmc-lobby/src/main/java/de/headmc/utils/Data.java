package de.headmc.utils;

import de.headmc.core.Core;
import de.headmc.core.api.CoinsAPI;
import de.headmc.core.manager.ActionbarManager;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.manager.ScoreboardManager;
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
import org.bukkit.scoreboard.*;

import javax.swing.*;
import java.util.ArrayList;

public class Data {

    public static ArrayList<Player> build = new ArrayList<>();
    public static ArrayList<Player> hidePlayer = new ArrayList<>();
    ScoreboardManager scoreboardManager = new ScoreboardManager();

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


        ScoreboardManager scoreboardManager = new ScoreboardManager();
        Scoreboard scoreboard = player.getScoreboard();

        scoreboardManager.createTeam(player.getScoreboard(), "01Admin");
        scoreboardManager.createTeam(player.getScoreboard(), "02Spieler");

        scoreboard.getTeam("01Admin").setPrefix("§4Admin §8| §4");
        scoreboard
                .getTeam("02Spieler").setPrefix("§7");

        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

        scoreboardManager.setLine(13, "§8§m----------------");
        scoreboardManager.setLine(12, "§3");
        scoreboardManager.setLine(11, " §8» §7Rang");
        if(permissionPlayer.hasPermissionGroup("Admin")) {
            scoreboardManager.setLine(10, " §8➥ §4Admin");
        } else if(permissionPlayer.hasPermissionGroup("SrDeveloper")) {
            scoreboardManager.setLine(10, " §8➥ §bSrDeveloper");
        } else if(permissionPlayer.hasPermissionGroup("Developer")){
            scoreboardManager.setLine(10, " §8➥ §bDeveloper");
        }else if(permissionPlayer.hasPermissionGroup("Builder")){
            scoreboardManager.setLine(10, " §8➥ §2Builder");
        }else if(permissionPlayer.hasPermissionGroup("Supporter")){
            scoreboardManager.setLine(10, " §8➥ §3Supporter");
        }else if(permissionPlayer.hasPermissionGroup("Moderator")){
            scoreboardManager.setLine(10, " §8➥ §9Moderator");
        }else if(permissionPlayer.hasPermissionGroup("SrModerator")){
            scoreboardManager.setLine(10, " §8➥ §9SrModerator");
        }else if(permissionPlayer.hasPermissionGroup("Freund")){
            scoreboardManager.setLine(10, " §8➥ §fFreund");
        }else if(permissionPlayer.hasPermissionGroup("SrContent")){
            scoreboardManager.setLine(10, " §8➥ §cSrContent");
        }else if(permissionPlayer.hasPermissionGroup("Content")){
            scoreboardManager.setLine(10, " §8➥ §cContent");
        }else if(permissionPlayer.hasPermissionGroup("Prime")){
            scoreboardManager.setLine(10, " §8➥ §6PRime");
        }else if(permissionPlayer.hasPermissionGroup("YouTuber")){
            scoreboardManager.setLine(10, " §8➥ §5YouTuber");
        }else if(permissionPlayer.hasPermissionGroup("Premium+")){
            scoreboardManager.setLine(10, " §8➥ §ePremium§6+");
        }else if(permissionPlayer.hasPermissionGroup("Head")){
            scoreboardManager.setLine(10, " §8➥ §3Head");
        }else {
            scoreboardManager.setLine(10, " §8➥ §7Spieler");
        }
            scoreboardManager.setLine(9, "§1");
            scoreboardManager.setLine(8, "§8» §7Coins");
            scoreboardManager.setLine(7, " §8➥ §3§l" + new CoinsAPI().getCoinsSpigot(player));
            scoreboardManager.setLine(6, "§2");
            scoreboardManager.setLine(5, " §8» §7Hoster");
            scoreboardManager.setLine(4, " §8➥ §3§lVenocix.de");
            scoreboardManager.setLine(3, "§4");
            scoreboardManager.setLine(2, "§8§m----------------§7");


        for(Player all : Bukkit.getOnlinePlayers()){

            String team = "02Spieler";

            if(permissionPlayer.hasPermissionGroup("Spieler"))
                team = "02Spieler";
            else if(permissionPlayer.hasPermissionGroup("Admin"))
                team = "01Admin";

            Team t = scoreboard.getTeam(team);
            if(t == null) t =scoreboard.registerNewTeam(team);
            t.addEntry(all.getName());
            all.setDisplayName(t.getPrefix()  + player.getName());
        }

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

