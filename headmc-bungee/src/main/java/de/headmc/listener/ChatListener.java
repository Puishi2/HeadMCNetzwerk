package de.headmc.listener;

import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import org.bukkit.event.EventHandler;

/**
 * JavaDoc this file!
 * Created: 19.01.2021
 *
 * @author Phexxo (phexxoyt@gmail.com)
 */
public class ChatListener implements Listener {

    @EventHandler
    public void onChat(ChatEvent event) {
        if(event.getMessage().equals("/tc login")) {
            event.setCancelled(true);
        }
    }

}
