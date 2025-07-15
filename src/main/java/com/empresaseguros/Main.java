package com.empresaseguros;


import com.empresaseguros.data.ClienteDAO;
import com.empresaseguros.data.PropiedadDAO;
import com.empresaseguros.data.ServicioDAO;
import com.empresaseguros.model.Cliente;
import com.empresaseguros.model.Propiedad;
import com.empresaseguros.model.Servicio;
import com.empresaseguros.utils.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    ServicioDAO serviciobd = new ServicioDAO();
    Servicio nuevoServicio = new Servicio(6,2,"Cobertura contra accidentes","Para vehiculos",250000);



       boolean exito = serviciobd.insertarServicio(nuevoServicio);

    if (exito){
        System.out.println("Se inserto el servicio correctamente");
    } else {
        System.out.println("El servicio no pudo ser insertado, verifique cliente y propiedad.");
    }


    }
}