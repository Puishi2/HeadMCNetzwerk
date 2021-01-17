package de.headmc.bansystem.manager;

import de.headmc.bansystem.sql.MySQL;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.command.ConsoleCommandSender;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BanManager {

    public boolean isBanned(String uuid){

    try {
        PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("SELECT * FROM bansystem WHERE UUID =?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            preparedStatement.close();
            return true;
        }
    }catch (SQLException e){
        e.printStackTrace();
    }


    return false;
    }

    public void setBanned(String victim, CommandSender sender, String category){

        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement("INSERT INTO bansystem (UUID, CATERGORY, BANNER) VALUES(?,?, ?)");
            preparedStatement.setString(1, victim);
            preparedStatement.setString(2, category + ";");
            preparedStatement.setString(3, sender.getName());
            if(sender instanceof ConsoleCommandSender)
                preparedStatement.setString(3, "CONSOLE");
                else
                    preparedStatement.setString(3, ((ProxiedPlayer)sender).getUniqueId().toString());
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
