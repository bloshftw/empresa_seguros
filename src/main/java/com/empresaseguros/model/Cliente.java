package com.empresaseguros.model;

import java.time.LocalDate;

public class Cliente {

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_nacimiento;
    private double sueldo;

    //Constructor
    public Cliente(String nombre, String apellido, String dni, LocalDate fecha_nacimiento, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sueldo = sueldo;
    };

    //Constructor Vacio
    public Cliente() {
    };

    //Getters and setter


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    public String toString() {
        return "Nombre del cliente: " + this.nombre + "\n" +
               "Apellido del cliente: " + this.apellido + "\n" +
               "DNI: " + this.dni + "\n" +
               "Fecha de nacimiento: " + this.fecha_nacimiento + "\n" +
               "Sueldo del cliente: " + this.sueldo;
    }
}
