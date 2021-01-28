package de.headmc.listener.lottery;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.data.Data;
import de.headmc.core.lottery.LotteryManager;
import de.headmc.core.manager.ActionbarManager;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class LotteryListenner implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractAtEntityEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getRightClicked().getCustomName().equalsIgnoreCase("§5§lLottery")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 27, "§8» §5Lottery");

            for(int i = 0; i < 27; i++) {

                ItemStack blackPane = new ItemStack(new ItemManager(Material.STAINED_GLASS_PANE).setDurability((short) 15).setDisplayName("§8 ").toItemStack());
                inventory.setItem(i, blackPane);

            }

            inventory.setItem(11, new ItemManager(Material.PAPER).setDisplayName("§8» §aEinlösen").addLoreLine("§8» §7Deine Tickets §8: §c" + LotteryManager.getLotteryTickets(player)).addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
            inventory.setItem(15, new ItemManager(Material.GOLD_NUGGET).setDisplayName("§8» §6Kaufen").addLoreLine("§8» §7Preis §8: §c250 Coins").toItemStack());

            player.openInventory(inventory);

        }

    }

    @EventHandler
    public void onInvClick(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §5Lottery")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Kaufen")) {

                if(new CoinsAPI().getCoinsSpigot(player) >= 250) {

                    LotteryManager.addTickets(player, 1);
                    new CoinsAPI().removeCoinsSpigot(player, 250);
                    player.sendMessage(Data.NETWORK_PREFIX + "Du hast dir ein Ticket gekauft!");
                    player.closeInventory();
                    Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 2);
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

                } else {

                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDu hast nicht genügend Coins!");

                }

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aEinlösen")) {

                if(LotteryManager.getLotteryTickets(player) >= 1) {

                    LotteryManager.removeTickets(player, 1);
                    Random random = new Random();
                    int coins = random.nextInt(500);
                    new CoinsAPI().addCoinsSpigot(player, coins);
                    player.closeInventory();
                    Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 2);
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                    ActionbarManager.setTitle(player, "§8✗ §5Lottery §8✗", "§8» §7Du hast §2" + coins + " §7Coins gewonnen!", 10, 40, 10);

                } else {

                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDu hast nicht genügend Tickets!");

                }

            }

        }

    }

}
