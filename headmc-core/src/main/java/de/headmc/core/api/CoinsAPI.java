package de.headmc.core.api;

import de.headmc.core.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinsAPI {

    public boolean exists(Player player) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM coins WHERE UUID='" + player.getUniqueId() + "';");
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

    public int getCoins(Player player) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM coins WHERE UUID='" + player.getUniqueId() + "';");
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

    public void addCoins(Player player, int size) {
        int coins = getCoins(player) + size;
        MySQL.update("UPDATE coins SET coins='" + coins + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public void removeCoins(Player player, int size) {
        int coins = getCoins(player) - size;
        MySQL.update("UPDATE coins SET coins='" + coins + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public void setCoins(Player player, int size) {
        MySQL.update("UPDATE coins SET coins='" + size + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public void createPlayer(Player player) {
        if (!exists(player)) {
            try {
                PreparedStatement State = MySQL.getConnection().prepareStatement("INSERT INTO coins VALUES ('" + player.getUniqueId() + "', 0);");
                State.execute();
                State.close();
            } catch (SQLException exception) {
                Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
                Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            }
        }
    }

}
