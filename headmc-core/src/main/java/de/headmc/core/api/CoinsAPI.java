package de.headmc.core.api;

import de.headmc.core.sql.MySQL;
import net.md_5.bungee.api.connection.ProxiedPlayer;
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

    public int getCoinsSpigot(Player player) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM coins WHERE UUID='" + player.getUniqueId() + "';");
            ResultSet Result = State.executeQuery();
            Result.next();
            int stats1 = Result.getInt("coins");
            Result.close();
            State.close();
            return stats1;
        } catch (SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
            Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            return 0;
        }
    }

    public void addCoinsSpigot(Player player, int size) {
        int coins = getCoinsSpigot(player) + size;
        MySQL.update("UPDATE coins SET coins='" + coins + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public void removeCoinsSpigot(Player player, int size) {
        int coins = getCoinsSpigot(player) - size;
        MySQL.update("UPDATE coins SET coins='" + coins + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public void setCoinsSpigot(Player player, int size) {
        MySQL.update("UPDATE coins SET coins='" + size + "' WHERE uuid='" + player.getUniqueId() + "'");
    }

    public void createPlayer(Player player) {
        if (!exists(player)) {
            try {
                PreparedStatement State = MySQL.getConnection().prepareStatement("INSERT INTO coins VALUES ('" + player.getUniqueId() + "', 100);");
                State.execute();
                State.close();
            } catch (SQLException exception) {
                Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
                Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            }
        }
    }

}
