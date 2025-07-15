package com.empresaseguros.data;

import com.empresaseguros.model.Propiedad;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropiedadDAO {

    //Metodo para crear una propiedad e insertarla.

    public boolean insertarPropiedad (Propiedad propiedad) {

        String sql = "INSERT INTO propiedades (direccion, metros_cuadrados, valor_mercado, zona) VALUES (?,?,?,?)";

        try (Connection conectar = Conexion.getConnection();
             PreparedStatement p = conectar.prepareStatement(sql)) {

            p.setString(1, propiedad.getDireccion());
            p.setDouble(2, propiedad.getMetros_cuadrados());
            p.setDouble(3, propiedad.getValor_mercado());
            p.setString(4, propiedad.getZona());

            int filasAfectadas = p.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error, detalles: " + e.getMessage());
            return false;
        }

    }

        //Metodo para verificar la existencia de la propiedad a traves de su ID unico.


    public boolean verificarPropiedad (int idPropiedad) {

        String sql = "SELECT 1 FROM propiedades WHERE codigo_propiedad = ?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idPropiedad);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.out.println("Hubo un error al consultar la existencia de la propiedad, detalles: " + e.getMessage());
            return false;
        }
    }




}
