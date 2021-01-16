package de.headmc.listener.lobbyitems;

import de.headmc.core.api.CoinsAPI;
import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.data.Data;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.player.HeadMCPlayer;
import eu.thesimplecloud.module.permission.PermissionPool;
import eu.thesimplecloud.module.permission.group.IPermissionGroup;
import eu.thesimplecloud.module.permission.group.PermissionGroup;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import eu.thesimplecloud.module.permission.player.PlayerPermissionGroupInfo;
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
import java.util.concurrent.TimeUnit;

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
                inventory.setItem(20, new ItemManager(Material.DIAMOND).setDisplayName("§8» §6Prime §8- §61 Monat").addLoreLine("§8» §710.000 Coins").toItemStack());
                inventory.setItem(24, new ItemManager(Material.REDSTONE).setDisplayName("§8» §3Head §8- §31 Monat").addLoreLine("§8» §75.000 Coins").toItemStack());
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
    public void onInvClick4(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §6Shop")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Prime §8- §61 Monat")) {

                if(new CoinsAPI().getCoinsSpigot(player) >= 10000) {

                    long time = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30);

                    IPermissionPlayer iPermissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

                    if(!iPermissionPlayer.hasPermissionGroup("Admin") || iPermissionPlayer.hasPermissionGroup("SrDeveloper") || iPermissionPlayer.hasPermissionGroup("Developer") || iPermissionPlayer.hasPermissionGroup("SrModerator") || iPermissionPlayer.hasPermissionGroup("Content") || iPermissionPlayer.hasPermissionGroup("SrContent") || iPermissionPlayer.hasPermissionGroup("Builder") || iPermissionPlayer.hasPermissionGroup("Premium+") || iPermissionPlayer.hasPermissionGroup("YouTuber") || iPermissionPlayer.hasPermissionGroup("Moderator") || iPermissionPlayer.hasPermissionGroup("Supporter") || iPermissionPlayer.hasPermissionGroup("Freund")) {

                        if(!iPermissionPlayer.hasPermissionGroup("Prime")) {

                            iPermissionPlayer.clearGroups();
                            iPermissionPlayer.addPermissionGroup(new PlayerPermissionGroupInfo("Prime", time));
                            iPermissionPlayer.update();

                            player.closeInventory();
                            player.sendMessage(Data.NETWORK_PREFIX + "Du hast dir den §6Prime §7Rang gekauft!");
                            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

                            new CoinsAPI().removeCoinsSpigot(player, 10000);

                        } else {
                            player.sendMessage(Data.NETWORK_PREFIX + "§cDu besitzt bereits diesen Rang!");
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                        }

                    } else {
                        player.sendMessage(Data.NETWORK_PREFIX + "§cDu hast bereits einen besseren Rang!");
                        player.closeInventory();
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }

                } else {
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDu hast zu wenig Coins!");
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                }

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §3Head §8- §31 Monat")) {

                if(new CoinsAPI().getCoinsSpigot(player) >= 5000) {

                    long time = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30);

                    IPermissionPlayer iPermissionPlayer = PermissionPool.getInstance().getPermissionPlayerManager().getCachedPermissionPlayer(player.getUniqueId());

                    if(!iPermissionPlayer.hasPermissionGroup("Admin") || iPermissionPlayer.hasPermissionGroup("SrDeveloper") || iPermissionPlayer.hasPermissionGroup("Developer") || iPermissionPlayer.hasPermissionGroup("SrModerator") || iPermissionPlayer.hasPermissionGroup("Content") || iPermissionPlayer.hasPermissionGroup("SrContent") || iPermissionPlayer.hasPermissionGroup("Builder") || iPermissionPlayer.hasPermissionGroup("Premium+") || iPermissionPlayer.hasPermissionGroup("YouTuber") || iPermissionPlayer.hasPermissionGroup("Moderator") || iPermissionPlayer.hasPermissionGroup("Supporter") || iPermissionPlayer.hasPermissionGroup("Freund") || iPermissionPlayer.hasPermissionGroup("Prime")) {

                        if(!iPermissionPlayer.hasPermissionGroup("Head")) {

                            iPermissionPlayer.clearGroups();
                            iPermissionPlayer.addPermissionGroup(new PlayerPermissionGroupInfo("Head", time));
                            iPermissionPlayer.update();

                            player.closeInventory();
                            player.sendMessage(Data.NETWORK_PREFIX + "Du hast dir den §3Head §7Rang gekauft!");
                            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

                            new CoinsAPI().removeCoinsSpigot(player, 5000);

                        } else {
                            player.sendMessage(Data.NETWORK_PREFIX + "§cDu besitzt bereits diesen Rang!");
                            player.closeInventory();
                            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                        }

                    } else {
                        player.sendMessage(Data.NETWORK_PREFIX + "§cDu hast bereits einen besseren Rang!");
                        player.closeInventory();
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }

                } else {
                    player.sendMessage(Data.NETWORK_PREFIX + "§cDu hast zu wenig Coins!");
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
                    player.closeInventory();
                }

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
