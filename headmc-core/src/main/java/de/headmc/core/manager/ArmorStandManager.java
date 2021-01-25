package de.headmc.core.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;


public class ArmorStandManager {

    public ArmorStand spawnArmorstand(Location location, String name, ItemStack skull, boolean visible, boolean showName, boolean gravity, boolean basePlate) {

        ArmorStand armorStand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(location, EntityType.ARMOR_STAND);

        armorStand.setVisible(visible);
        armorStand.setCustomName(name);
        armorStand.setCustomNameVisible(showName);
        armorStand.setHelmet(skull);
        armorStand.setGravity(gravity);
        armorStand.setBasePlate(basePlate);

        return armorStand;
    }

}
