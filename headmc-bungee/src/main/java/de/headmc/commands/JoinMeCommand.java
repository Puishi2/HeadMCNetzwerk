package de.headmc.commands;

import de.headmc.data.Data;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;

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

            for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                TextComponent textComponent = new TextComponent(String.valueOf("§c§l Klicke hier!"));
                textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("§2Verbinden").create())));
                textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "abcdefghijk" + player.getServer().getInfo().getName()));

                ProxyServer.getInstance().broadcast("§8§m------------------");
                ProxyServer.getInstance().broadcast("§1");
                ProxyServer.getInstance().broadcast("§7Der Spieler §2" + player.getName() + "§7 Spielt auf §2" + player.getServer().getInfo().getName());
                ProxyServer.getInstance().broadcast((BaseComponent) textComponent);
                ProxyServer.getInstance().broadcast("§2");
                ProxyServer.getInstance().broadcast("§8§m------------------§7");
                }
            }else{
                return;
            }

        }

    }
}
