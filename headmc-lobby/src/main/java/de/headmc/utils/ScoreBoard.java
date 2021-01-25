package de.headmc.utils;

import de.headmc.core.api.CoinsAPI;
import de.headmc.lobby.Lobby;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

public class ScoreBoard {

    public void setBoard(Player p) {

        Player player;

        Scoreboard sb = new Scoreboard();
        ScoreboardObjective obj = sb.registerObjective("dummy", IScoreboardCriteria.b);
        obj.setDisplayName("§8✗ §2§lHeadMC.de §8✗");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);
        IPermissionPlayer permissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(p.getUniqueId());

        ScoreboardScore a0 = new ScoreboardScore(sb, obj, "§8§m----------------");
        ScoreboardScore a1 = new ScoreboardScore(sb, obj, "§1");
        ScoreboardScore a2 = new ScoreboardScore (sb, obj, " §8» §7Rang");
        ScoreboardScore a3;
        if(permissionPlayer.hasPermissionGroup("Admin")) {
            a3 = new ScoreboardScore (sb, obj, " §8➥ §4Admin");
        } else if(permissionPlayer.hasPermissionGroup("SrDeveloper")) {
            a3 = new ScoreboardScore (sb, obj, " §8➥ §bSrDeveloper");
        } else if(permissionPlayer.hasPermissionGroup("Developer")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §bDeveloper");
        }else if(permissionPlayer.hasPermissionGroup("Builder")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §2Builder");
        }else if(permissionPlayer.hasPermissionGroup("Supporter")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §3Supporter");
        }else if(permissionPlayer.hasPermissionGroup("Moderator")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §9Moderator");
        }else if(permissionPlayer.hasPermissionGroup("SrModerator")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §9SrModerator");
        }else if(permissionPlayer.hasPermissionGroup("Freund")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §fFreund");
        }else if(permissionPlayer.hasPermissionGroup("SrContent")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §cSrContent");
        }else if(permissionPlayer.hasPermissionGroup("Content")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §cContent");
        }else if(permissionPlayer.hasPermissionGroup("Prime")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §6Prime");
        }else if(permissionPlayer.hasPermissionGroup("YouTuber")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §5YouTuber");
        }else if(permissionPlayer.hasPermissionGroup("Premium+")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §6Premium§e+");
        }else if(permissionPlayer.hasPermissionGroup("Head")){
            a3 = new ScoreboardScore (sb, obj, " §8➥ §3Head");
        }else {
            a3 = new ScoreboardScore (sb, obj, " §8➥ §7Spieler");
        }

        ScoreboardTeam team = sb.createTeam("x6");
        team.setPrefix("§8");
        team.setSuffix(" §8➥ §2§l" + new CoinsAPI().getCoinsSpigot(p));
        //sb.team

        ScoreboardScore a4 = new ScoreboardScore(sb, obj, "§2");
        ScoreboardScore a5 = new ScoreboardScore(sb, obj, " §8» §7Coins");

        new BukkitRunnable() {
            @Override
            public void run() {
                ScoreboardScore a6 = new ScoreboardScore(sb, obj, " §8➥ §2§l" + new CoinsAPI().getCoinsSpigot(p));

                a6.setScore(6);
                PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
                sendPacket(p, pa6);


            }
        }.runTaskTimer(Lobby.getInstance(), 0, 40);

        ScoreboardScore a7 = new ScoreboardScore(sb, obj, "§0");
        ScoreboardScore a8 = new ScoreboardScore(sb, obj, " §8» §7Hoster");
        ScoreboardScore a9 = new ScoreboardScore(sb, obj, " §8➥ §2§lVenocix.de");
        ScoreboardScore a10 = new ScoreboardScore(sb, obj, "§4");
        ScoreboardScore a11 = new ScoreboardScore(sb, obj, "§8§m----------------§7");

        a0.setScore(12);
        a1.setScore(11);
        a2.setScore(10);
        a3.setScore(9);
        a4.setScore(8);
        a5.setScore(7);
        a7.setScore(5);
        a8.setScore(4);
        a9.setScore(3);
        a10.setScore(2);
        a11.setScore(1);

        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa0 = new PacketPlayOutScoreboardScore(a0);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
        PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(a9);
        PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(a10);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);

        sendPacket(p, removePacket);
        sendPacket(p, createPacket);
        sendPacket(p, display);

        sendPacket(p, pa0);
        sendPacket(p, pa1);
        sendPacket(p, pa2);
        sendPacket(p, pa3);
        sendPacket(p, pa4);
        sendPacket(p, pa5);
        sendPacket(p, pa7);
        sendPacket(p, pa8);
        sendPacket(p, pa9);
        sendPacket(p, pa10);
        sendPacket(p, pa11);
    }

    @SuppressWarnings("rawtypes")
    private void sendPacket(Player p, Packet packet) {
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

}
