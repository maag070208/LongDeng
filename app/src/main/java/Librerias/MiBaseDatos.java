package Librerias;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;

public class MiBaseDatos extends SQLiteOpenHelper {
    public static final String Tabla_Productos="CREATE TABLE productos("+
            "codigo TEXT, descripcion TEXT, precio TEXT, cantidad TEXT, imagen BLOB);";
    public MiBaseDatos(Context contexto){
        super(contexto, "practica9.sqlite", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tabla_Productos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tabla_Productos);
    }
}
