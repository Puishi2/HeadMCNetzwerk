package de.headmc.commands;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getServer().getPlayer(args[0]);

        if(player.hasPermission("headmc.coins.set")) {

            if(args.length == 2) {

                if(target != null) {

                    int coins = Integer.parseInt(args[1]);
                    new CoinsAPI().setCoinsSpigot(target, coins);
                    player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Coins von §3" + target.getName() + " §7auf §3" + coins + " §7gesetzt!");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                    target.sendMessage(Data.NETWORK_PREFIX + "Deine Coins wurden auf §3" + coins + " §7gesetzt!");
                    target.playSound(target.getLocation(), Sound.LEVEL_UP, 1, 1);

                } else {
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDieser Spieler ist nicht online!");
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                }

            } else {
                player.sendMessage(Data.NETWORK_PREFIX + "§cBenutze /setcoins <Name> <Coins>!");
            }

        } else {
            player.sendMessage(Data.NETWORK_PREFIX + "§cDazu hast du keine Rechte!");
        }

        return false;
    }

}
