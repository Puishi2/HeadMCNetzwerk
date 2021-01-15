package de.headmc.report.commands;

import de.headmc.data.Data;
import eu.thesimplecloud.api.CloudAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.UUID;

public class ReportCommand extends Command {



    public ReportCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {



        if(!(commandSender instanceof ProxiedPlayer)){
            return;
        }else {
            ProxiedPlayer player = (ProxiedPlayer)commandSender;
            ProxiedPlayer proxiedTarget = ProxyServer.getInstance().getPlayer(strings[0]);
            UUID uuid = player.getUniqueId();

            if(strings[0].equalsIgnoreCase("login")){
                Data.report.add(uuid);
                player.sendMessage(Data.PROXY_PREFIX + "Du hast dich erfolgreich ins §3ReporSystem §aeingeloggt§8.");

            }else if(strings[0].equalsIgnoreCase("logout")){

                Data.report.remove(uuid);
                player.sendMessage(Data.PROXY_PREFIX + "Du hast dich erfolgreich ins §3ReporSystem §causgeloggt§8.");


            }else{
                return;
            }

            if(strings.length == 0){

                player.sendMessage(Data.PROXY_PREFIX + "Du musst §3/report §8(§3Spieler§8) §8(Grund§8) §7benutzen.");
            }
            else if(strings.length == 1){
                player.sendMessage(Data.PROXY_PREFIX + "Du musst §3/report §8(§3Spieler§8) §8(Grund§8) §7benutzen.");
            }
            else if(strings.length >1){

                String reason = "";

                for(int i = 1; i < strings.length; i++){

                    reason = "§3" + reason + strings[i] + "§7 ";
                }
                if(proxiedTarget != null){
                    if(!proxiedTarget.getName().equalsIgnoreCase(player.getName())){
                        player.sendMessage(Data.PROXY_PREFIX + "Du hast den Spieler §3" + proxiedTarget.getName() + "§7 erfoglreich Reportet");



                           for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()){

                               if(Data.report.contains(uuid)){

                                   players.sendMessage("§8§m------§3ReportSystem§8§m-----");
                                   players.sendMessage("§4");
                                   players.sendMessage("§8➥ §7Name §8» §3" + proxiedTarget.getName());
                                   players.sendMessage("§8➥ §7Grund §8» §3" +reason);
                                   players.sendMessage("§8➥ §7Server §8» §3" + ProxyServer.getInstance().getServerInfo(player.getName()));
                                   players.sendMessage("§8➥ §7Ersteller §8» §3" + player.getName());
                                   players.sendMessage("§3");
                                   player.sendMessage("§8§m-------------------------------");

                               }else{
                                   return;
                               }

                           }
                    }else{

                        player.sendMessage(Data.PROXY_PREFIX + "Du kannst dich nicht selber §eReporten §7:-)");

                    }
                }else{

                    player.sendMessage(Data.PROXY_PREFIX + "Der angegebende §3Spieler §7ist nicht online.");

                }
            }

        }

    }
}
