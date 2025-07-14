package com.empresaseguros;


import com.empresaseguros.data.ClienteDAO;
import com.empresaseguros.model.Cliente;
import com.empresaseguros.model.Propiedad;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    Cliente cliente1 = new Cliente("Ramona","Barzola","24261506",LocalDate.parse("1978-10-30"),1195000);

    ClienteDAO clienteConexion = new ClienteDAO();

    boolean exito = clienteConexion.insertarCliente(cliente1);

        if(exito){
            System.out.println("Insercion exitosa!");
        } else {
            System.out.println("Hubo un error.");
        }

    }
}