package de.headmc.core.manager;

import com.google.common.collect.Maps;
import javafx.beans.binding.MapBinding;
import kotlin.jvm.internal.MagicApiIntrinsics;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Map;
import java.util.Objects;

public class ScoreboardManager {

    private Map<Integer, String> scoreMap = Maps.newConcurrentMap();

    public void setLine(int score, String prefix){

        this.scoreMap.put(score, prefix + ";");

    }

    public void setBoard(final Player player){

        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("aaa", "bbb");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§8✗ §3§lHeadMC.de §8✗");

        for(int i = 0; i < 20; i++){

            if(this.scoreMap.get(i) != null){
                Team scorebaordTeam;
                String[] raw;

                if(i < 10){

                    scorebaordTeam = scoreboard.registerNewTeam("x" + i);
                    raw = ((String) this.scoreMap.get(i)).split(";");

                    scorebaordTeam.setPrefix(raw[0]);
                    scorebaordTeam.setPrefix(raw[1]);
                    scorebaordTeam.addEntry("§" + i);
                    objective.getScore("§" + i).setScore(i);

                }else{



                }

            }




        }

    }


    private String getColorCodeByNumber(int number){

        switch (number){

            case 10:
                return "a";
            case 11:
                return "m";
            case 12:
                return  "l";
            case 13:
                return "3";
            case 14:
                return "b";
            case 15:
                return "c";
            case 16:
                return "d";
            case 17:
                return "e";
            case 18:
                return "f";
            default:
                return "z";

        }

    }


    public void createTeam(Scoreboard sb, String teams){
        Team team = sb.getTeam(teams);

        if(team == null){
            team = sb.registerNewTeam(teams);
        }
    }

}
