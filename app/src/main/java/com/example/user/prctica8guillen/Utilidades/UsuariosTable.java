package com.example.user.prctica8guillen.Utilidades;

public class UsuariosTable {

    //Constantes Campos tabla usuarios
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CORREO = "correo";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + "(" +
            CAMPO_ID + " INTEGER, " +
            CAMPO_NOMBRE + " TEXT, " +
            CAMPO_CORREO + " TEXT)";
}
