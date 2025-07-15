package com.empresaseguros;


import com.empresaseguros.data.ClienteDAO;
import com.empresaseguros.data.PropiedadDAO;
import com.empresaseguros.model.Cliente;
import com.empresaseguros.model.Propiedad;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    Propiedad casa1 = new Propiedad("Belgica 2123",90,35000000,"Villa Celestina");

    PropiedadDAO propiedadConexion = new PropiedadDAO();

    boolean exito = propiedadConexion.insertarPropiedad(casa1);

    if (exito){
        System.out.println("Se logro insertar la propiedad correctamente");
    } else {
        System.out.println("Hubo un error.");
    }

    }
}