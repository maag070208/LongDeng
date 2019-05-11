package com.example.user.prctica8guillen.Utilidades;

public class OrdenTable {
    public static final String TABLA_ORDEN = "orden";
    public static final String CAMPO_NUMERO = "numero";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_PRECIO = "precio";
    public static final String CAMPO_MESA = "mesa";

    public static final String CREAR_TABLA_ORDEN = "CREATE TABLE " + TABLA_ORDEN + " (" +
            CAMPO_NUMERO + " INTEGER," +
            CAMPO_DESCRIPCION + " TEXT," +
            CAMPO_NOMBRE + " TEXT," +
            CAMPO_PRECIO + " DOUBLE," +
            CAMPO_MESA + " INTEGER);";
}
