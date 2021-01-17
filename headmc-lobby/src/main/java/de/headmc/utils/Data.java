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
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    public static ArrayList<Player> build = new ArrayList<>();
    public static ArrayList<Player> hidePlayer = new ArrayList<>();
    ScoreboardManager scoreboardManager = new ScoreboardManager();
    private static HashMap<Scoreboard, Player> board = new HashMap<>();


    public static void loadedefaultsSettings(Player player){

        player.setFoodLevel(20);
        player.setHealthScale(6);
        ActionbarManager.setTitle(player, "§8✗ §2HeadMC.de §8✗", "§7Willkommen auf HeadMC!", 10, 40, 10);
        player.setGameMode(GameMode.ADVENTURE);

    }

    public void loadJoinitems(Player player){

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        ItemStack nav = new ItemManager(Material.BOOK).setDisplayName("§8» §2§LNavigator §8× §7Rechtsclick").toItemStack();

        player.getInventory().setItem(0, nav);
        player.getInventory().setItem(1, new ItemManager(Material.GLOWSTONE_DUST).setDisplayName("§8» §c§lPrivater Server §8× §7Rechtsclick").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
        player.getInventory().setItem(4, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025")).setDisplayName("§8» §cKein Gadget").toItemStack());
        player.getInventory().setItem(7, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622")).setDisplayName("§8» §2§lExtras §8× §7Rechtsclick").toItemStack());
        player.getInventory().setItem(8, new ItemManager(Material.REDSTONE_COMPARATOR).setDisplayName("§8» §2§LEinstellungen §8× §7Rechtsclick").toItemStack());

    }

    public void setTab(Player p){

        PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;


        IChatBaseComponent tabHeader = IChatBaseComponent.ChatSerializer.a("{\"text\": \"§2§lHeadMC\"}");
        IChatBaseComponent tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\": \"§7TeamSpeak §8» §2HeadMC.de\"}");

        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter(tabHeader);


        try{
            Field f = packet.getClass().getDeclaredField("b");
            f.setAccessible(true);
            f.set(packet, tabFooter);

        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            connection.sendPacket(packet);
        }

    }

    public void createScoreboard(HeadMCPlayer headMCPlayer, Player player) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("aaa", "bbb");

        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§8✗ §2§lHeadMC.de §8✗");

        objective.getScore("§8§m----------------").setScore(13);
        objective.getScore("§1").setScore(12);
        objective.getScore(" §8» §7Rang").setScore(11);
        if(permissionPlayer.hasPermissionGroup("Admin")) {
            objective.getScore(" §8➥ §4Admin").setScore(10);
        } else if(permissionPlayer.hasPermissionGroup("SrDeveloper")) {
            objective.getScore(" §8➥ §bSrDeveloper").setScore(10);
        } else if(permissionPlayer.hasPermissionGroup("Developer")){
            objective.getScore(" §8➥ §bDeveloper").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Builder")){
            objective.getScore(" §8➥ §2Builder").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Supporter")){
            objective.getScore(" §8➥ §3Supporter").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Moderator")){
            objective.getScore(" §8➥ §9Moderator").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("SrModerator")){
            objective.getScore(" §8➥ §9SrModerator").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Freund")){
            objective.getScore(" §8➥ §fFreund").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("SrContent")){
            objective.getScore(" §8➥ §cSrContent").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Content")){
            objective.getScore(" §8➥ §cContent").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Prime")){
            objective.getScore(" §8➥ §6Prime").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("YouTuber")){
            objective.getScore(" §8➥ §5YouTuber").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Premium+")){
            objective.getScore(" §8➥ §ePremium+").setScore(10);
        }else if(permissionPlayer.hasPermissionGroup("Head")){
            objective.getScore(" §8➥ §3Head").setScore(10);
        }else {
            objective.getScore(" §8➥ §7Spieler").setScore(10);
        }
        objective.getScore("§2").setScore(9);
        objective.getScore("§8» §7Coins").setScore(8);
        objective.getScore("§0").setScore(6);
        objective.getScore(" §8» §7Hoster").setScore(5);
        objective.getScore(" §8➥ §2§lVenocix.de").setScore(4);
        objective.getScore("§4").setScore(3);
        objective.getScore("§8§m----------------§7").setScore(2);

        Team team = scoreboard.registerNewTeam("x7");
        team.setPrefix("§8");
        team.setSuffix(" §8➥ §2§l" + new CoinsAPI().getCoinsSpigot(player));
        team.addEntry("§3");
        objective.getScore("§3").setScore(7);

        player.setScoreboard(scoreboard);
        board.put(scoreboard, player);

    }

    public void updateScoreboard() {
        try {
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Scoreboard scoreboard : board.keySet()) {
                        Player player = board.get(scoreboard);
                        scoreboard.getTeam("x7").setSuffix(" §8➥ §2§l" + new CoinsAPI().getCoinsSpigot(player));
                    }
                }
            }.runTaskTimer(Lobby.getInstance(), 0, 140);
        }catch (Exception e) {}

    }

    public void sendActionbar(Player player) {

        new BukkitRunnable() {
            @Override
            public void run() {
                ActionbarManager.setActionBar(player, "§8» §7Spielzeit §8× §20 min §8┃ §7Clan §8× §cKein Clan");
            }
        }.runTaskTimer(Lobby.getInstance(), 0, 40);

    }

    public void navigatorTeleport(Player player, Location location) {

        try {

            player.closeInventory();

            player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 5, 10);

            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1, 1));

            player.setVelocity(new org.bukkit.util.Vector(0, 30, 0));

            player.playSound(player.getLocation(), Sound.DOOR_CLOSE, 100, 100);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Lobby.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 10);
                    player.teleport(location);
                    player.removePotionEffect(PotionEffectType.BLINDNESS);
                }
            }, 15L);

        } catch (Exception exception) {}

    }

}

