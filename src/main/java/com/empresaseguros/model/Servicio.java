package com.empresaseguros.model;

public class Servicio {
    /// Relaciones entre tablas
    private int numero_cliente;
    private int codigo_propiedad;

    private int codigo;
    private String tipo;
    private String detalle_cobertura;
    private double precio;

    //Constructor
    public Servicio(int numero_cliente, int codigo_propiedad, String tipo, String detalle_cobertura, double precio) {
        this.numero_cliente = numero_cliente;
        this.codigo_propiedad = codigo_propiedad;
        this.codigo = codigo;
        this.tipo = tipo;
        this.detalle_cobertura = detalle_cobertura;
        this.precio = precio;
    }

    //Constructor para extraer y armar el objeto con su PK respectiva


    public Servicio(int numero_cliente, int codigo_propiedad, int codigo, String tipo, String detalle_cobertura, double precio) {
        this.numero_cliente = numero_cliente;
        this.codigo_propiedad = codigo_propiedad;
        this.codigo = codigo;
        this.tipo = tipo;
        this.detalle_cobertura = detalle_cobertura;
        this.precio = precio;
    }

    //Constructor vacio
    public Servicio(){};

    //Getters and setter


    public int getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(int numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public int getCodigo_propiedad() {
        return codigo_propiedad;
    }

    public void setCodigo_propiedad(int codigo_propiedad) {
        this.codigo_propiedad = codigo_propiedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle_cobertura() {
        return detalle_cobertura;
    }

    public void setDetalle_cobertura(String detalle_cobertura) {
        this.detalle_cobertura = detalle_cobertura;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString(){

        return "Codigo de servicio: " + this.codigo + "\n" +
               "Tipo de cobertura: " + this.tipo + "\n" +
               "Detalle: " + this.detalle_cobertura + "\n" +
               "Precio: " + this.precio + "\n" +
               "-------------------------------------";

    }

}



