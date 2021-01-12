package de.headmc.core.sql;

import org.bukkit.Bukkit;

import java.sql.*;

public class MySQL {

    private static String HOST;
    private static String DATABASE;
    private static String USER;
    private static String PASSWORD;

    private static Connection connection;

    public MySQL(String host, String database, String user, String password) {
        this.HOST = host;
        this.DATABASE = database;
        this.USER = user;
        this.PASSWORD = password;

        connect();
        createTables();
    }

    public static void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?autoReconnect=true", USER, PASSWORD);
            Bukkit.getConsoleSender().sendMessage("§a[MySQL] Die Verbindung war Erfolgreich!");
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("§c[MySQL] Die Verbindung ist Fehlgeschlagen! Fehler:" + e.getMessage());
        }
    }

    public void close() {
        try {
            if(connection != null) {
                connection.close();
                Bukkit.getConsoleSender().sendMessage("[MySQL] Die Verbindung zur MySQL wurde Erfolgreich beendet!");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("[MySQL] Fehler beim beenden der Verbindung zur MySQL! Fehler: " + e.getMessage());
        }
    }

    public static void update(String qry) {
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(qry);
            st.close();
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;

        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException e) {
            connect();
            System.err.println(e);
        }
        return rs;
    }

    public static void createTables() {
        update("CREATE TABLE IF NOT EXISTS coins (UUID varchar(64), coins varchar(64));");
    }


}
