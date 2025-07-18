package com.empresaseguros.model;

import java.text.DecimalFormat;

public class Propiedad {

    private int codigoPropiedad;
    private String direccion;
    private double metros_cuadrados;
    private double valor_mercado;
    private String zona;

    //Constructor
    public Propiedad(String direccion, double metros_cuadrados, double valor_mercado, String zona) {
        this.direccion = direccion;
        this.metros_cuadrados = metros_cuadrados;
        this.valor_mercado = valor_mercado;
        this.zona = zona;
    };

    //Constructor con ID


    public Propiedad(int codigoPropiedad, String direccion, double metros_cuadrados, double valor_mercado, String zona) {
        this.codigoPropiedad = codigoPropiedad;
        this.direccion = direccion;
        this.metros_cuadrados = metros_cuadrados;
        this.valor_mercado = valor_mercado;
        this.zona = zona;
    }

    //Constructor vacio
    public Propiedad(){};

    //Constructor para mostrar en conjunto con servicios

    public Propiedad(int codigoPropiedad, String direccion, String zona, double precioMercado) {
    this.codigoPropiedad = codigoPropiedad;
    this.direccion = direccion;
    this.zona = zona;
    this.valor_mercado = precioMercado;
    }

    //Getters and setters


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMetros_cuadrados() {
        return metros_cuadrados;
    }

    public void setMetros_cuadrados(double metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    public double getValor_mercado() {
        return valor_mercado;
    }

    public void setValor_mercado(double valor_mercado) {
        this.valor_mercado = valor_mercado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }


    public String toString() {

        DecimalFormat formato = new DecimalFormat("#,###.00");

        return  "Codigo: " + this.codigoPropiedad + "\n" +
                "Direccion de la propiedad: " + this.direccion + "\n" +
               "Zona de la propiedad: " + this.zona + "\n" +
               "Metros cuadrados: " + this.metros_cuadrados + "\n" +
               "Valor en mercado: " + " $" + formato.format(this.valor_mercado) + "\n";
    };
}
