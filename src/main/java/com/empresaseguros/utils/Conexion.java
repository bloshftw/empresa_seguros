package com.empresaseguros.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static final Properties props = new Properties();

   static {
       try{
           FileInputStream fis = new FileInputStream("config.properties");
           props.load(fis);
       } catch (IOException e){
           System.out.println("No se pudo cargar el archivo properties" + e.getMessage());
       }
   }


    public static Connection getConnection() {

        try{
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            System.out.println("Hubo un error al conectar a la base de datos, informacion del error: " + e.getMessage());
            return null;

        }

    }

}
