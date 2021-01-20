package de.headmc.core.lottery;

import de.headmc.core.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LotteryManager {

    public static boolean exists(Player player) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM lottery WHERE uuid='" + player.getUniqueId() + "';");
            ResultSet Result = State.executeQuery();
            boolean Contains = Result.next();
            State.close();
            Result.close();
            return Contains;
        } catch (SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
            Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            return true;
        }
    }

    public static int getLotteryTickets(Player player) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM lottery WHERE uuid='" + player.getUniqueId() + "';");
            ResultSet Result = State.executeQuery();
            Result.next();
            int stats1 = Result.getInt("tickets");
            Result.close();
            State.close();
            return stats1;
        } catch (SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
            Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            return 0;
        }
    }

    public static void addTickets(Player player, int size) {
        int newtickets = getLotteryTickets(player) + size;
        MySQL.update("UPDATE lottery SET tickets='" + newtickets + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public static void removeTickets(Player player, int size) {
        int newtickets = getLotteryTickets(player) - size;
        MySQL.update("UPDATE lottery SET tickets='" + newtickets + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public static void setTickets(Player player, int size) {
        MySQL.update("UPDATE lottery SET tickets='" + size + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public static void createPlayer(Player player) {
        if (!exists(player)) {
            try {
                PreparedStatement State = MySQL.getConnection().prepareStatement("INSERT INTO lottery VALUES ('" + player.getUniqueId() + "', 0);");
                State.execute();
                State.close();
            } catch (SQLException exception) {
                Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
                Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            }
        }
    }

}
