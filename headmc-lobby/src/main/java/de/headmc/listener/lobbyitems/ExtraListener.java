package de.headmc.listener.lobbyitems;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class ExtraListener implements Listener {

    public static ArrayList<Player> herzspur = new ArrayList<>();
    public static ArrayList<Player> rainbow = new ArrayList<>();
    public static ArrayList<Player> wolkenspur = new ArrayList<>();


    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3§lExtras §8× §7Rechtsclick")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §3§lExtras");
            InventoryBuilder.setInvRand(inventory, player);

            inventory.setItem(20, new ItemManager(Material.FISHING_ROD).setDisplayName("§8» §aGadgets").toItemStack());
            inventory.setItem(22, new ItemManager(Material.INK_SACK).setDisplayName("§8» §eSpuren").setDurability((short) 11).toItemStack());
            inventory.setItem(24, new ItemManager(Material.GOLD_NUGGET).setDisplayName("§8» §6Shop").toItemStack());
            inventory.setItem(30, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());
            inventory.setItem(32, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());

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

        if(event.getInventory().getName().equalsIgnoreCase("§8» §3§lExtras")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aGadgets")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §aGadgets");
                InventoryBuilder.setInvRand(inventory, player);

                inventory.setItem(20, new ItemManager(Material.FISHING_ROD).setDisplayName("§8» §aEnterhaken").toItemStack());
                inventory.setItem(22, new ItemManager(Material.ENDER_PEARL).setDisplayName("§8» §5Enderperle").toItemStack());
                inventory.setItem(24, new ItemManager(Material.FLINT).setDisplayName("§8» §cBooster").toItemStack());
                inventory.setItem(30, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());
                inventory.setItem(32, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());

                inventory.setItem(49, new ItemManager(Material.REDSTONE).setDisplayName("§8» §cEntfernen").toItemStack());

                player.openInventory(inventory);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eSpuren")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §eSpuren");
                InventoryBuilder.setInvRand(inventory, player);

                inventory.setItem(20, new ItemManager(Material.INK_SACK).setDurability((short) 1).setDisplayName("§8» §cHerz-Spur").toItemStack());
                inventory.setItem(22, new ItemManager(Material.SLIME_BALL).setDisplayName("§8» §aSchleim-Spur").toItemStack());
                inventory.setItem(24, new ItemManager(Material.INK_SACK).setDurability((short) 15).setDisplayName("§8» §fWolken-Spur").toItemStack());
                inventory.setItem(30, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());
                inventory.setItem(32, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());

                inventory.setItem(49, new ItemManager(Material.REDSTONE).setDisplayName("§8» §cEntfernen").toItemStack());

                player.openInventory(inventory);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Shop")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §6Shop");
                InventoryBuilder.setInvRand(inventory, player);

                inventory.setItem(22, new ItemManager(Material.PAPER).setDisplayName("§8» §aJoinme-Tokens").toItemStack());
                inventory.setItem(20, new ItemManager(Material.DIAMOND).setDisplayName("§8» §bPrime").toItemStack());
                inventory.setItem(24, new ItemManager(Material.REDSTONE).setDisplayName("§8» §cHead").toItemStack());
                inventory.setItem(30, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());
                inventory.setItem(32, new ItemManager(Material.BARRIER).setDisplayName("§8» §cKommt bald...").toItemStack());

                player.openInventory(inventory);

            }

        }

    }

    @EventHandler
    public void onClick1(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §aGadgets")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aEnterhaken")) {

                player.getInventory().setItem(4, new ItemManager(Material.FISHING_ROD).setDisplayName("§8» §aEnterhaken").setUnbrak().toItemStack());
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Enderperle")) {

                player.getInventory().setItem(4, new ItemManager(Material.ENDER_PEARL).setDisplayName("§8» §5Enderperle").toItemStack());
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cBooster")) {

                player.getInventory().setItem(4, new ItemManager(Material.FLINT).setDisplayName("§8» §cBooster").toItemStack());
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cEntfernen")) {

                player.getInventory().setItem(4, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025")).setDisplayName("§8» §cKein Gadget").toItemStack());
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            }

        }

    }

    @EventHandler
    public void onInvClick2(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §eSpuren")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cHerz-Spur")) {

                herzspur.add(player);
                rainbow.remove(player);
                wolkenspur.remove(player);
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aSchleim-Spur")) {

                rainbow.add(player);
                herzspur.remove(player);
                wolkenspur.remove(player);
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §fWolken-Spur")) {

                wolkenspur.add(player);
                herzspur.remove(player);
                rainbow.remove(player);
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.CLICK, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cEntfernen")) {

                wolkenspur.remove(player);
                herzspur.remove(player);
                rainbow.remove(player);
                player.closeInventory();
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                Bukkit.getWorld("world").playEffect(player.getLocation(), Effect.FLAME, 1);

            }

        }

    }

    @EventHandler
    public void onMove(final PlayerMoveEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        for(Player all : Bukkit.getOnlinePlayers()) {

            if(herzspur.contains(player)) {
                all.spigot().playEffect(player.getLocation(), Effect.HEART, 0, 0, 0, 0, 0, 0, 2, 1);
            } else if(rainbow.contains(player)) {
                all.spigot().playEffect(player.getLocation(), Effect.SLIME, 0, 0, 0, 0, 0, 0, 2, 1);
            } else if(wolkenspur.contains(player)) {
                all.spigot().playEffect(player.getLocation(), Effect.CLOUD, 0, 0, 0, 0, 0, 0, 2, 1);
            }

        }

    }

}
