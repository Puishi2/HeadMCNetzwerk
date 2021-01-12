package de.headmc.effects;

import de.headmc.core.effects.ParticleManager;
import de.headmc.lobby.Lobby;
import de.headmc.utils.LocationManager;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnParticles {

    public void spawnParticles() {

        new BukkitRunnable() {
            @Override
            public void run() {
                new ParticleManager().spawnSpellCircle(new LocationManager().getLocation("spawn"), 1);
            }
        }.runTaskTimer(Lobby.getInstance(), 0, 40);

    }

}
