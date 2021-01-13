package de.headmc.core.manager;

import de.headmc.core.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                PreparedStatement State = MySQL.getConnection().prepareStatement("INSERT INTO settings VALUES ('" + player.getUniqueId() + "', 1);");
                State.execute();
                State.close();
            } catch (SQLException exception) {
                Bukkit.getConsoleSender().sendMessage("" + exception.getErrorCode());
                Bukkit.getConsoleSender().sendMessage("" + exception.getMessage());
            }
        }
    }

    public static Integer getSoundSettings(String uuid) {
        ResultSet resultSet = MySQL.getSqlData("SELECT sounds FROM settings WHERE UUID ='" + uuid + "'");
        Integer o = 0;
        try {
            while (resultSet.next()) {
                o = resultSet.getInt("sounds");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }

    public void setSoundSettings(String uuid, int zahl) {
        MySQL.update("UPDATE settings SET sounds ='" + zahl + "' WHERE UUID='" + uuid + "'");
    }

}
