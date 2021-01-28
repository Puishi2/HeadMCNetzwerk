package de.headmc.core.effects;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;

public class ParticleManager {

    public void spawnCircle(Location location, int size, Effect effect) {

        for (int degree = 2; degree < 360; degree++) {

            double radians = Math.toRadians(degree);
            double x = Math.cos(radians) * size;
            double z = Math.sin(radians) * size;
            location.add(x, 0, z);

            Bukkit.getWorld("world").playEffect(location, effect, 1);

            location.subtract(x, 0, z);

        }

    }

    public void spawnParticle(Location location, Effect effect) {

        Bukkit.getWorld("world").playEffect(location, effect, 1);

    }

}
