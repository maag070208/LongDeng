package com.example.user.prctica8guillen.Utilidades;

public class MenuTable {
    public static final String TABLA_MENU = "menu";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_PRECIO = "precio";

    public static final String CREAR_TABLA_MENU = "CREATE TABLE " + TABLA_MENU + " (" +
            CAMPO_NOMBRE + " TEXT," +
            CAMPO_DESCRIPCION + " TEXT," +
            CAMPO_PRECIO + " DOUBLE);";
}
