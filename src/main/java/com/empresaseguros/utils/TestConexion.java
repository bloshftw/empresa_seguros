package com.empresaseguros.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

    public static void main(String[] args) {

        try (Connection conexionTest = Conexion.getConnection()){

            if (conexionTest != null){
                System.out.println("La conexion fue un exito");
            } else {
                System.out.println("La conexion no pudo realizarse");
            }

        } catch (SQLException e){
            System.out.println("La conexion tuvo un error, detalle del error: " + e.getMessage());
        }
    }

}
