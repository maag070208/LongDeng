package com.example.user.prctica8guillen;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.user.prctica8guillen.Utilidades.UsuariosTable.TABLA_USUARIO;

public class Ventana1Activity extends Activity {

    EditText NoEmpleado;
    EditText nombre;
    ConexionSQLiteHelper conn;


    Button Confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ventana1);

        NoEmpleado = (EditText) findViewById(R.id.NoEmpleadoInicio);


    }

    public void IniciarSesion(View view) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        String query = "SELECT*FROM " + TABLA_USUARIO + " WHERE id = ' " + NoEmpleado.getText().toString() + " ' ; ";

        Cursor c = db.rawQuery(query, null);

        if (c.getCount() > 0) {

            if (NoEmpleado.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Ups! haz no has puesto Password", Toast.LENGTH_SHORT).show();

            } else {
                Intent miIntento = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(miIntento);
                Toast.makeText(getApplicationContext(), "Inicio Correctamente", Toast.LENGTH_LONG).show();

            }


        } else {
            Toast.makeText(getApplicationContext(), "No se Encontro al Empleado", Toast.LENGTH_LONG).show();

        }
    }


    public void Registrar(View view) {
        Intent miIntento = new Intent(getApplicationContext(), RegistrarActivity.class);
        startActivity(miIntento);


    }


}
