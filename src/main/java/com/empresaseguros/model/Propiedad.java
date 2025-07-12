package com.empresaseguros.model;

import java.text.DecimalFormat;

public class Propiedad {

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

    //Constructor vacio
    public Propiedad(){};

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

        return "Direccion de la propiedad: " + this.direccion + "\n" +
               "Zona de la propiedad: " + this.zona + "\n" +
               "Metros cuadrados: " + this.metros_cuadrados + "\n" +
               "Valor en mercado: " + " $" + formato.format(this.valor_mercado) + "\n";
    };
}
