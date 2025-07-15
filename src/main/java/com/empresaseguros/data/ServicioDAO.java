package com.empresaseguros.data;

import com.empresaseguros.model.Servicio;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicioDAO {

    //Metodo para crear un nuevo servicio

    public boolean insertarServicio (Servicio servicio){

        //Instancia de las clases de cliente y propiedad para usar sus metodos

        ClienteDAO clientebd = new ClienteDAO();
        PropiedadDAO propiedadbd = new PropiedadDAO();

        boolean clienteExiste = clientebd.verificarCliente(servicio.getNumero_cliente());
        boolean propiedadExiste = propiedadbd.verificarPropiedad(servicio.getCodigo_propiedad());

        if (clienteExiste && propiedadExiste){
            //Pasamos a la insercion del servicio ya que se verifico que existen ambas.

            String sql = "INSERT INTO servicios (tipo, detalle_cobertura, precio, numero_cliente, codigo_propiedad) VALUES (?,?,?,?,?)";

            try (Connection conexion = Conexion.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql)){

                ps.setString(1, servicio.getTipo());
                ps.setString(2, servicio.getDetalle_cobertura());
                ps.setDouble(3, servicio.getPrecio());
                ps.setInt(4, servicio.getNumero_cliente());
                ps.setInt(5, servicio.getCodigo_propiedad());

                int filasAfectadas = ps.executeUpdate();

                return filasAfectadas > 0;

            } catch (SQLException e){
                System.out.println("Hubo un error al generar un nuevo servicio, detalles: " + e.getMessage());
                return false;
            }

        } else if (clienteExiste == true && propiedadExiste == false){
            System.out.println("No se logro encontrar la propiedad en la base de datos, no existe.");
        } else if (clienteExiste == false && propiedadExiste == true){
            System.out.println("No se encontro el cliente en la base de datos, no existe.");
        } else {
            System.out.println("No se encontraron datos del cliente ni de la propiedad en la base de datos.");
        }
        return false;
    }


}
