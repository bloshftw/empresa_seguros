package com.empresaseguros.data;

import com.empresaseguros.model.Cliente;
import com.empresaseguros.utils.Conexion;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {



    //Metodo para crear un cliente e insertarlo.
    public boolean insertarCliente(Cliente cliente){

    String sql = "INSERT INTO clientes (nombre, apellido, dni, fecha_nacimiento, sueldo) VALUES (?,?,?,?,?)";

    try (Connection conectar = Conexion.getConnection();
         PreparedStatement pstmt = conectar.prepareStatement(sql)) {

        pstmt.setString(1, cliente.getNombre());
        pstmt.setString(2, cliente.getApellido());
        pstmt.setString(3, cliente.getDni());
        pstmt.setDate(4, java.sql.Date.valueOf(cliente.getFecha_nacimiento()));
        pstmt.setDouble(5, cliente.getSueldo());

        int filasAfectadas = pstmt.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e){
        System.out.println("Hubo un error, detalles: " + e.getMessage());
        return false;
    }
}


    //Metodo para verificar si un cliente existe atraves del ID del cliente
    public boolean verificarCliente (int idCliente) {

        String sql = "SELECT 1 FROM clientes WHERE numero_cliente = ?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e){
            System.out.println("Error al verificar la existencia del cliente, detalles: " + e.getMessage());
            return false;
        }

    }

    //Metodo para traer todos los clientes de la lista, solo incluyendo nombre, apellido, dni, numero de cliente (El ID), fecha de nacimiento y sueldo.

    public List<Cliente> obtenerTodosLosClientes(){

        //Creo la lista
        List<Cliente> listaDeClientes = new ArrayList<>();

        //Sentencia sql para traer todos los clientes
        String sql = "SELECT * FROM CLIENTES";

        //ResultSET que contendra datos
        ResultSet datos = null;

        try (Connection conexion = Conexion.getConnection();
            PreparedStatement ps = conexion.prepareStatement(sql)) {

        datos = ps.executeQuery(sql);

        while (datos.next()){
            int numeroCliente = datos.getInt("numero_cliente"); //PRIMARY KEY
            String nombre = datos.getString("nombre");
            String apellido = datos.getString("apellido");
            String dni = datos.getString("dni");
            Double sueldo = datos.getDouble("sueldo");
            LocalDate fecha_nacimiento = datos.getDate("fecha_nacimiento").toLocalDate();

            Cliente cliente = new Cliente(numeroCliente,nombre,apellido,dni,fecha_nacimiento,sueldo);

            listaDeClientes.add(cliente);
        }

        } catch (SQLException e){
            System.out.println("Ocurrio un error: " + e.getMessage());

        }

        //Retorno la lista de clientes como objeto, usando la clase "Cliente" como molde.
        return listaDeClientes;

    }

    //Clase para mostrar un cliente por su ID

    public Cliente buscarCliente (int idCliente){

        Cliente cliente = null;

        String sql = "SELECT * FROM clientes WHERE numero_cliente = ?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)){

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    int id = rs.getInt("numero_cliente");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String dni = rs.getString("dni");
                    LocalDate fechaNacimiento = rs.getDate("fecha_nacimiento").toLocalDate();
                    double sueldo = rs.getDouble("sueldo");

                    cliente = new Cliente(id,nombre,apellido,dni,fechaNacimiento,sueldo);

                }

            }

        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }

        return cliente;
    }

}
