package com.empresaseguros;


import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Connection conexion = Conexion.getConnection();

        if (conexion != null){
            System.out.println("Se ha hecho la conexion con exito");

            try{
                conexion.close();
                System.out.println("Se cerro la conexion");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }



    }
}