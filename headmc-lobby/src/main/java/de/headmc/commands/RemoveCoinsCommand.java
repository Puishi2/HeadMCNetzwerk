package de.headmc.commands;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getServer().getPlayer(args[0]);

        if (player.hasPermission("headmc.coins.remove")) {

            if (args.length == 2) {

                if (target != null) {

                    int coins = Integer.parseInt(args[1]);
                    new CoinsAPI().removeCoinsSpigot(target, coins);
                    player.sendMessage(Data.NETWORK_PREFIX + "Du hast dem Spieler §3" + target.getName() + " " + coins + " §7Coin(s) entfernt!");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                    target.sendMessage(Data.NETWORK_PREFIX + "Dir wurden §3" + coins + "§7 Coin(s) entfernt!");
                    target.playSound(target.getLocation(), Sound.LEVEL_UP, 1, 1);

                    if(new CoinsAPI().getCoinsSpigot(player) < 0) {
                        new CoinsAPI().setCoinsSpigot(player, 0);
                    }

                } else {
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDieser Spieler ist nicht online!");
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                }

            } else {
                player.sendMessage(Data.NETWORK_PREFIX + "§cBenutze /removecoins <Name> <Coins>!");
            }

        } else {
            player.sendMessage(Data.NETWORK_PREFIX + "§cDazu hast du keine Rechte!");
        }

        return false;
    }

}
