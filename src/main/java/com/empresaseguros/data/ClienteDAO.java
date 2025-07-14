package com.empresaseguros.data;

import com.empresaseguros.model.Cliente;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

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

}
