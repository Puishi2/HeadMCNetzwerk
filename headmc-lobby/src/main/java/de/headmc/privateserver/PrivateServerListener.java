package de.headmc.privateserver;

import de.headmc.core.builder.InventoryBuilder;
import de.headmc.core.manager.ActionbarManager;
import de.headmc.core.manager.Base64;
import de.headmc.core.manager.ItemManager;
import de.headmc.core.manager.PrivateServerManager;
import de.headmc.core.player.HeadMCPlayer;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PrivateServerListener implements Listener {

    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {

        Player player = event.getPlayer();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c§lPrivater Server §8× §7Rechtsclick")) {

            Inventory inventory = InventoryBuilder.createInventory(player, 54, "§8» §cPrivater Server");
            InventoryBuilder.setInvRand(inventory, player);

            inventory.setItem(13, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/c95d37993e594082678472bf9d86823413c250d4332a2c7d8c52de4976b362"))
                .addLoreLine("§8» §7Erstelle einen privaten SkyWars-Server.").setDisplayName("§8» §2SkyWars").toItemStack());
            inventory.setItem(19, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/6fb290a13df88267ea5f5fcf796b6157ff64ccee5cd39d469724591babeed1f6"))
                    .addLoreLine("§8» §7Erstelle einen privaten BedWars-Server.").setDisplayName("§8» §cBedWars").toItemStack());
            inventory.setItem(25, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))
                    .setDisplayName("§8» §c§lKommt bald...").toItemStack());
            inventory.setItem(39, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))
                    .setDisplayName("§8» §c§lKommt bald...").toItemStack());
            inventory.setItem(41, new ItemManager(Base64.getSkull("http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"))
                    .setDisplayName("§8» §c§lKommt bald...").toItemStack());

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

        if(event.getInventory().getName().equalsIgnoreCase("§8» §cPrivater Server")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cBedWars")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §cBedWars");

                inventory.setItem(1, new ItemManager(Material.PAPER).setDisplayName("§8» §c2x1").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
                inventory.setItem(4, new ItemManager(Material.PAPER).setDisplayName("§8» §c8x1").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
                inventory.setItem(7, new ItemManager(Material.PAPER).setDisplayName("§8» §c4x2").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());

                player.openInventory(inventory);

            } if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §2SkyWars")) {

                Inventory inventory = InventoryBuilder.createInventory(player, 9, "§8» §2SkyWars");

                inventory.setItem(1, new ItemManager(Material.PAPER).setDisplayName("§8» §22x1").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
                inventory.setItem(4, new ItemManager(Material.PAPER).setDisplayName("§8» §28x1").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());
                inventory.setItem(7, new ItemManager(Material.PAPER).setDisplayName("§8» §24x2").addEnchant(Enchantment.ARROW_DAMAGE, 1).setFlags().toItemStack());

                player.openInventory(inventory);

            }

        }

    }

    @EventHandler
    public void onInvClick1(final InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        HeadMCPlayer headMCPlayer = new HeadMCPlayer(player.getName(), player.getUniqueId());

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        if(event.getInventory().getName().equalsIgnoreCase("§8» §cBedWars")) {

            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §c2x1")) {

                new PrivateServerManager().createServer(player, "BW2x1");
                player.closeInventory();
                ActionbarManager.setTitle(player, "§c§lPrivater Server", "§7Dein Server startet...", 10, 40, 10);
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

            }

        }

    }

}
