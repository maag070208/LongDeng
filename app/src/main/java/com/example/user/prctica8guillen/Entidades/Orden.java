package com.example.user.prctica8guillen.Entidades;

public class Orden {
    private int numero;
    private String descripcion;
    private String nombre;
    private double precio;
    private int mesa;

    public Orden(String descripcion, String nombre, double precio, int mesa) {
        setNumero(0);
        setDescripcion(descripcion);
        setNombre(nombre);
        setPrecio(precio);
        setMesa(mesa);
    }

    public int getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getMesa() {
        return mesa;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}
