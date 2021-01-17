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

            if(player.hasPermission("headmc.team")) {
                if (strings[0].equalsIgnoreCase("logout")) {

                    Data.report.remove(uuid);
                    player.sendMessage(Data.PROXY_PREFIX + "Du hast dich erfolgreich ins §3ReporSystem §causgeloggt§8.");


                } else if (strings[0].equalsIgnoreCase("login")) {

                    Data.report.add(uuid);
                    player.sendMessage(Data.PROXY_PREFIX + "Du hast dich erfolgreiech ins §3ReportSystem §aeingeloggt");


                }
            }else{
                player.sendMessage(Data.PROXY_PREFIX + "Du hast §3Keine §7Rechte!");
            }

            if(strings.length >1){

                String reason = "";

                for(int i = 1; i < strings.length; i++){

                    reason = "§3" + reason + strings[i] + "§7 ";
                }
                if(proxiedTarget != null){
                    if(!proxiedTarget.getName().equalsIgnoreCase(player.getName())){
                        player.sendMessage(Data.PROXY_PREFIX + "Du hast den Spieler §3" + proxiedTarget.getName() + "§7 erfoglreich Reportet");


                        if(Data.report.contains(uuid)){

                          for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()){

                              players.sendMessage("§8§m------§3ReportSystem§8§m-----");
                              players.sendMessage("§4");
                              players.sendMessage("§8➥ §7Name §8» §3" + proxiedTarget.getName());
                              players.sendMessage("§8➥ §7Grund §8» §3" +reason);
                              players.sendMessage("§8➥ §7Server §8» §3" +  proxiedTarget.getServer().getInfo().getName());
                              players.sendMessage("§8➥ §7Ersteller §8» §3" + player.getName());
                              players.sendMessage("§3");
                              player.sendMessage("§8§m-------------------------------");

                          }

                            player.sendMessage("§8§m-------------------------------");



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
