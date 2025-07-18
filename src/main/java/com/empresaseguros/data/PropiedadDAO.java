package com.empresaseguros.data;

import com.empresaseguros.model.Propiedad;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Propiedad> obtenerTodasLasPropiedades () {

        //Creamos la lista que contendra todas las propiedades
        List<Propiedad> listaPropiedades = new ArrayList<>();

        //Sentencia SQL
        String sql = "SELECT * FROM propiedades";

        try(Connection conexion = Conexion.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet datosPropiedades = ps.executeQuery()){

            while (datosPropiedades.next()){

                int codigoPropiedad = datosPropiedades.getInt("codigo_propiedad");
                String direccion = datosPropiedades.getString("direccion");
                double metrosCuadrados = datosPropiedades.getDouble("metros_cuadrados");
                double valorMercado = datosPropiedades.getDouble("valor_mercado");
                String zona = datosPropiedades.getString("zona");

                //Creamos el objeto propiedad y lo agregamos a la lista

                Propiedad propiedad = new Propiedad(codigoPropiedad,direccion,metrosCuadrados,valorMercado,zona);

                listaPropiedades.add(propiedad);
            }

        } catch (SQLException e){
            System.out.println("Hubo un error: " + e.getMessage());
        }

        if (listaPropiedades.size() > 0){

        } else if (listaPropiedades.size() == 0){
            System.out.println("No existen propiedades en la base de datos.");

        }

        return listaPropiedades;
    }




}
