package de.headmc.commands;

import de.headmc.data.Data;
import eu.thesimplecloud.api.CloudAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.minecraft.server.v1_8_R3.ChatClickable;
import net.minecraft.server.v1_8_R3.ChatComponentText;

import javax.sound.sampled.Line;
import javax.xml.bind.Marshaller;
import java.awt.*;

public class JoinMeCommand extends Command implements Listener {
    public JoinMeCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
    if(!(commandSender instanceof ProxiedPlayer)){
        return;
    }else{

        if(strings.length == 0){

            ProxiedPlayer player = (ProxiedPlayer)commandSender;

            player.sendMessage(Data.PROXY_PREFIX + "Du hast das §2JoinME§7 erfolgreich gesendet.");



            ProxyServer.getInstance().broadcast("§8§m------------------");
            ProxyServer.getInstance().broadcast("§3");
            ProxyServer.getInstance().broadcast("§7Der Spieler §2" + player.getName() + "§7 Spielt auf §2" + player.getServer().getInfo().getName());
            ProxyServer.getInstance().broadcast("§c§l Click Hier");
            ProxyServer.getInstance().broadcast("§4");
            ProxyServer.getInstance().broadcast("§8§m------------------§7");

        }else{
            return;
        }

    }


    }


        @EventHandler
        public void onChat(ChatEvent event){
        ProxiedPlayer player =(ProxiedPlayer) event.getSender();

        if(event.getMessage().equalsIgnoreCase("§c§l CLICK HIER")){



        }

    }
}
