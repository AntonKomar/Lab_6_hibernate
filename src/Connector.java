package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Connector {

    public static Connection connection;

    public static void connector() {
        String url="jdbc:postgresql://217.23.154.1:5432/labdb";
        String userName="dbroot";
        String password="pinkhorsegohome97";

           try {
               Class.forName("org.postgresql.Driver");
               connection = DriverManager.getConnection(url, userName, password);
               System.out.println("DB connected");
           } catch (SQLException ex) {
               ex.printStackTrace();
               System.out.println(" Error : SQL exception ");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
    }

    public static void disconnect() {
        try {
            connection.close();
            System.out.println(" DB is disconected ");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(" DB isn't disconected ");
        }
    }
}
