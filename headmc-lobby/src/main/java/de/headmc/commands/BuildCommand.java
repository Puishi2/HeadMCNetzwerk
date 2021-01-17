package de.headmc.commands;

import de.headmc.utils.Data;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))return true;
        Player player = (Player)sender;

        if(player.hasPermission("headmc.command.build")){

            if(args.length == 0){

                if(Data.build.contains(player)){
                    Data.build.remove(player);
                    new Data().loadJoinitems(player);
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(de.headmc.core.data.Data.NETWORK_PREFIX + "Du hast den §2Build-Modus §7erfolgreich deaktiviert.");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
                }else {
                    Data.build.add(player);
                    player.setGameMode(GameMode.CREATIVE);
                    player.getInventory().clear();
                    player.sendMessage(de.headmc.core.data.Data.NETWORK_PREFIX + "Du hast den §2Build-Modus §7erfolgreich Aktiviert.");
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 2, 2);
                }

            }else return true;

        }else player.sendMessage(de.headmc.core.data.Data.NETWORK_PREFIX + "§cKeine Rechte!");

        return false;
    }

    @EventHandler
    public void onBreak(final  BlockBreakEvent event){
        Player player = event.getPlayer();
        event.setCancelled(true);
        if(Data.build.contains(player)){
            event.setCancelled(false);
        }

    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent event){
        Player player = event.getPlayer();
        event.setCancelled(true);
        if(Data.build.contains(player)){
            event.setCancelled(false);
        }

    }

}
