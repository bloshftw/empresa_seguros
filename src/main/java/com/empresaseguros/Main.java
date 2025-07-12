package com.empresaseguros;


import com.empresaseguros.model.Cliente;
import com.empresaseguros.model.Propiedad;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Propiedad prop1 = new Propiedad("Asia 540",70,22550000,"Villa Rafaela");

        System.out.println(prop1.toString());

    }
}