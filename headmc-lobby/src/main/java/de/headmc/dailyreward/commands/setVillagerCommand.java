package de.headmc.dailyreward.commands;

import de.headmc.core.Core;
import de.headmc.core.data.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import java.rmi.activation.ActivationGroupDesc;

public class setVillagerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }else{

            Player player = (Player) sender;

            if(command.getName().equalsIgnoreCase("setvillager")){

                Villager v = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                v.setCustomName("§2§lTäglichebelohnung");

                player.sendMessage(Data.NETWORK_PREFIX + "Du hast den §2Villager §7erfolgreich gesetzt.");
            }else {

                player.sendMessage(Data.NETWORK_PREFIX + "Du hast eine Falschen Command angegeben");

            }
        }

        return false;
    }
}
