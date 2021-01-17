package de.headmc.commands;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddCoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getServer().getPlayer(args[0]);

        if(player.hasPermission("headmc.coins.add")) {

            if(args.length == 2) {

                if(target != null) {

                    int coins = Integer.parseInt(args[1]);
                    new CoinsAPI().addCoinsSpigot(target, coins);
                    player.sendMessage(Data.NETWORK_PREFIX + "Du hast dem Spieler §2" + target.getName()+ " " + coins + " §7Coin(s) hinzugefügt!");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                    target.sendMessage(Data.NETWORK_PREFIX + "Dir wurden §2" + coins + "§7 Coin(s) hinzugefügt!");
                    target.playSound(target.getLocation(), Sound.LEVEL_UP, 1, 1);

                } else {
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDieser Spieler ist nicht online!");
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                }

            } else {
                player.sendMessage(Data.NETWORK_PREFIX + "§cBenutze /addcoins <Name> <Coins>!");
            }

        } else {
            player.sendMessage(Data.NETWORK_PREFIX + "§cDazu hast du keine Rechte!");
        }

        return false;
    }
}
