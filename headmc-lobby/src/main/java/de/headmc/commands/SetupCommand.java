package de.headmc.commands;

import de.headmc.core.player.HeadMCPlayer;
import de.headmc.utils.LocationManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(player.hasPermission("headmc.lobby.setup")) {

            if(args.length == 1) {

                if(args[0].equalsIgnoreCase("spawn")) {

                    new LocationManager().saveLocation(player, "spawn");
                    headMCPlayer.sendMessageToSpigotPlayer(player, "Du hast die Location gesetzt!");

                } else if(args[0].equalsIgnoreCase("bedwars")) {

                    new LocationManager().saveLocation(player, "bedwars");
                    headMCPlayer.sendMessageToSpigotPlayer(player, "Du hast die Location gesetzt!");

                } else if(args[0].equalsIgnoreCase("skywars")) {

                    new LocationManager().saveLocation(player, "skywars");
                    headMCPlayer.sendMessageToSpigotPlayer(player, "Du hast die Location gesetzt!");

                } else if(args[0].equalsIgnoreCase("lottery")) {

                    new LocationManager().saveLocation(player, "lottery");
                    headMCPlayer.sendMessageToSpigotPlayer(player, "Du hast die Location gesetzt!");

                } else if(args[0].equalsIgnoreCase("case")) {

                    new LocationManager().saveLocation(player, "case");
                    headMCPlayer.sendMessageToSpigotPlayer(player, "Du hast die Location gesetzt!");

                }

            } else {
                headMCPlayer.sendMessageToSpigotPlayer(player, "§cBenutze /setup <Spawn, BedWars, SkyWars, Lottery, Case>!");
            }

        } else {
            headMCPlayer.sendNoPermissionMessage(player);
        }

        return false;
    }
}
