package de.headmc.effects;

import de.headmc.core.effects.ParticleManager;
import de.headmc.lobby.Lobby;
import de.headmc.utils.LocationManager;
import org.bukkit.Effect;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnParticles {

    public void spawnParticles() {

        new BukkitRunnable() {
            @Override
            public void run() {
                new ParticleManager().spawnCircle(new LocationManager().getLocation("spawn"), 1, Effect.SPELL);
            }
        }.runTaskTimer(Lobby.getInstance(), 0, 40);

    }

}
