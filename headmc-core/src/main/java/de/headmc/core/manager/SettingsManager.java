package de.headmc.core.manager;

import de.headmc.core.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SettingsManager {

    public boolean exists(Player player) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM settings WHERE UUID='" + player.getUniqueId() + "';");
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

    public void createPlayer(Player player) {
        if (!exists(player)) {
            try {
                PreparedStatement State = MySQL.getConnection().prepareStatement("INSERT INTO settings VALUES ('" + player.getUniqueId() + "', '1', '1', '1');");
                State.execute();
                State.close();
            } catch (SQLException exception) {
                Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
                Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            }
        }
    }

    public static int getSetting(String setting, String uuid) {
        try {
            PreparedStatement State = MySQL.getConnection().prepareStatement("SELECT * FROM settings WHERE UUID='" + uuid + "';");
            ResultSet Result = State.executeQuery();
            Result.next();
            int stats1 = Result.getInt(setting);
            Result.close();
            State.close();
            return stats1;
        } catch (SQLException exception) {
            Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
            Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            return 0;
        }
    }

    public static void setSetting(Player player, String setting, int value) {
        MySQL.update("UPDATE settings SET " + setting + "='" + value + "' WHERE UUID='" + player.getUniqueId() + "'");
    }

}
