package com.example.user.prctica8guillen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.user.prctica8guillen.Utilidades.MenuTable.CREAR_TABLA_MENU;
import static com.example.user.prctica8guillen.Utilidades.OrdenTable.CREAR_TABLA_ORDEN;
import static com.example.user.prctica8guillen.Utilidades.UsuariosTable.CREAR_TABLA_USUARIO;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIO);
        db.execSQL(CREAR_TABLA_MENU);
        db.execSQL(CREAR_TABLA_ORDEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS menu");
        db.execSQL("DROP TABLE IF EXISTS orden");
        onCreate(db);
    }


}





