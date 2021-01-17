package de.headmc.listener.lobbyitems;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.data.Data;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.manager.SettingsManager;
import de.headmc.core.player.HeadMCPlayer;
import eu.thesimplecloud.api.CloudAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SettingsListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §2§lEinstellungen §8× §7Rechtsclick")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §2§lEinstellungen");
            InventoryBuilder.setInvRand(inventory, player);

            inventory.setItem(20, new ItemManager(Material.REDSTONE_COMPARATOR).setDisplayName("§8» §cEinstellungen").toItemStack());
            inventory.setItem(22, new ItemManager(Material.GLOWSTONE_DUST).setDisplayName("§8» §eLobbys").toItemStack());
            inventory.setItem(24, new ItemManager(Material.NAME_TAG).setDisplayName("§8» §5Nick-Tool").toItemStack());

            player.openInventory(inventory);

        }

    }

    @EventHandler
    public void onInvClick(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if (event.getInventory().getName().equalsIgnoreCase("§8» §2§lEinstellungen")) {

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cEinstellungen")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §cEinstellungen");
                InventoryBuilder.setInvRand(inventory, player);

                inventory.setItem(20, new ItemManager(Material.FISHING_ROD).setDisplayName("§8» §cHotbar-Sounds").toItemStack());
                inventory.setItem(22, new ItemManager(Material.ENDER_PEARL).setDisplayName("§8» §cSichtbarkeit").toItemStack());
                inventory.setItem(24, new ItemManager(Material.FLINT).setDisplayName("§8» §cPartikel").toItemStack());

                player.openInventory(inventory);

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eLobbys")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §eLobbys");


                if(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Silent-Hub-1").isOnline()) {
                    inventory.setItem(8, new ItemManager(Material.EXPLOSIVE_MINECART).addLoreLine("§8» §7" + CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Silent-Hub-1").getOnlineCount() + " Spieler online").setDisplayName("§8» §cSilent-Hub").toItemStack());
                } else {
                    inventory.setItem(8, new ItemManager(Material.AIR).toItemStack());
                }

                if(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-1").isOnline()) {
                    inventory.setItem(0, new ItemManager(Material.STAINED_CLAY).setDurability((short) 5).addLoreLine("§8» §7" + CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-1").getOnlineCount() + " Spieler online").setDisplayName("§8» §aLobby-1").toItemStack());
                } else {
                    inventory.setItem(0, new ItemManager(Material.STAINED_CLAY).setDurability((short) 14).setDisplayName("§8» §cLobby-1").toItemStack());
                }

                if(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-2").isOnline()) {
                    inventory.setItem(1, new ItemManager(Material.STAINED_CLAY).setDurability((short) 5).addLoreLine("§8» §7" + CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-2").getOnlinePlayers()).setDisplayName("§8» §aLobby-2").toItemStack());
                } else {
                    inventory.setItem(1, new ItemManager(Material.STAINED_CLAY).setDurability((short) 14).setDisplayName("§8» §cLobby-2").toItemStack());
                }

                if(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-3").isOnline()) {
                    inventory.setItem(2, new ItemManager(Material.STAINED_CLAY).setDurability((short) 5).addLoreLine("§8» §7" + CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-3").getOnlinePlayers()).setDisplayName("§8» §aLobby-3").toItemStack());
                } else {
                    inventory.setItem(2, new ItemManager(Material.STAINED_CLAY).setDurability((short) 14).setDisplayName("§8» §cLobby-3").toItemStack());
                }

                if(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-4").isOnline()) {
                    inventory.setItem(3, new ItemManager(Material.STAINED_CLAY).setDurability((short) 5).addLoreLine("§8» §7" + CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-4").getOnlinePlayers()).setDisplayName("§8» §aLobby-4").toItemStack());
                } else {
                    inventory.setItem(3, new ItemManager(Material.STAINED_CLAY).setDurability((short) 14).setDisplayName("§8» §cLobby-4").toItemStack());
                }

                if(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-5").isOnline()) {
                    inventory.setItem(4, new ItemManager(Material.STAINED_CLAY).setDurability((short) 5).addLoreLine("§8» §7" + CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-5").getOnlinePlayers()).setDisplayName("§8» §aLobby-5").toItemStack());
                } else {
                    inventory.setItem(4, new ItemManager(Material.STAINED_CLAY).setDurability((short) 14).setDisplayName("§8» §cLobby-5").toItemStack());
                }

                player.openInventory(inventory);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §5Nick-Tool")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §5Nick-Tool");

                inventory.setItem(2, new ItemManager(Material.INK_SACK).setDisplayName("§8» §aAktivieren").setDurability((short) 10).toItemStack());
                inventory.setItem(6, new ItemManager(Material.INK_SACK).setDurability((short) 1).setDisplayName("§8» §cDeaktivieren").toItemStack());

                player.openInventory(inventory);

            }

        }

    }

    @EventHandler
    public void onInvClick2(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §cEinstellungen")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cHotbar-Sounds")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §cHotbar-Sounds §8* §cEinstellungen");

                inventory.setItem(2, new ItemManager(Material.INK_SACK).setDisplayName("§8» §aAktivieren").setDurability((short) 10).toItemStack());
                inventory.setItem(6, new ItemManager(Material.INK_SACK).setDurability((short) 1).setDisplayName("§8» §cDeaktivieren").toItemStack());

                player.openInventory(inventory);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cSichtbarkeit")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §cSichtbarkeit §8* §cEinstellungen");

                inventory.setItem(2, new ItemManager(Material.INK_SACK).setDisplayName("§8» §aAktivieren").setDurability((short) 10).toItemStack());
                inventory.setItem(6, new ItemManager(Material.INK_SACK).setDurability((short) 1).setDisplayName("§8» §cDeaktivieren").toItemStack());

                player.openInventory(inventory);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cPartikel")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §cPartikel §8* §cEinstellungen");

                inventory.setItem(2, new ItemManager(Material.INK_SACK).setDisplayName("§8» §aAktivieren").setDurability((short) 10).toItemStack());
                inventory.setItem(6, new ItemManager(Material.INK_SACK).setDurability((short) 1).setDisplayName("§8» §cDeaktivieren").toItemStack());

                player.openInventory(inventory);

            }

        }

    }

    @EventHandler
    public void onInvClick3(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §cHotbar-Sounds §8* §cEinstellungen")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aAktivieren")) {

                SettingsManager.setSetting(player, "sounds", 1);
                player.closeInventory();
                player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Einstellungen geändert!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cDeaktivieren")) {

                SettingsManager.setSetting(player, "sounds", 0);
                player.closeInventory();
                player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Einstellungen geändert!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

            }

        } else if(event.getInventory().getName().equalsIgnoreCase("§8» §cSichtbarkeit §8* §cEinstellungen")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aAktivieren")) {

                SettingsManager.setSetting(player, "player", 1);
                player.closeInventory();
                player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Einstellungen geändert!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cDeaktivieren")) {

                SettingsManager.setSetting(player, "player", 0);
                player.closeInventory();
                player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Einstellungen geändert!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

            }

        } else if(event.getInventory().getName().equalsIgnoreCase("§8» §cPartikel §8* §cEinstellungen")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aAktivieren")) {

                SettingsManager.setSetting(player, "particle", 1);
                player.closeInventory();
                player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Einstellungen geändert!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

                de.headmc.utils.Data.hidePlayer.forEach(hider -> {
                    hider.showPlayer(player);
                });

            } else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cDeaktivieren")) {

                SettingsManager.setSetting(player, "particle", 0);
                player.closeInventory();
                player.sendMessage(Data.NETWORK_PREFIX + "Du hast die Einstellungen geändert!");
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

                de.headmc.utils.Data.hidePlayer.forEach(hider -> {
                    hider.hidePlayer(player);
                });

            }

        }

    }

}
