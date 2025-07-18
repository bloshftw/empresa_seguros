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
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteDAO clienteBD = new ClienteDAO();
        PropiedadDAO propiedadBD = new PropiedadDAO();
        ServicioDAO servicioBD = new ServicioDAO();


        List<Servicio> listaDeServicios = servicioBD.obtenerCoberturas();

        for (Servicio s : listaDeServicios) {
            System.out.println(s.toString());

            System.out.println("Detalles del cliente: \n" );
            Cliente c = clienteBD.buscarCliente(s.getNumero_cliente());
            System.out.println(c.toString());


            System.out.println("---Aca se separan los servicios y clientes---");

        }

    }
}