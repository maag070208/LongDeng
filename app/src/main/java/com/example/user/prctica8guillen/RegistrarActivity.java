package com.example.user.prctica8guillen;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.prctica8guillen.Utilidades.UsuariosTable;

public class RegistrarActivity extends AppCompatActivity {

    EditText campoId, campoNombre, campoCorreo;
    Button btn;

    String upsText = "Ups! no haz puesto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registrar);
        campoId = findViewById(R.id.idRegistro);
        campoNombre = findViewById(R.id.nombreRegistro);
        campoCorreo = findViewById(R.id.correoRegistro);
        btn = findViewById(R.id.RegistrarBtnReg);
    }
    
    public void RegitrarReg(View v) {
        try {
            ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();

            if (campoId.getText().toString().equals("")) {
                toast( upsText + " password");


            } else {
                values.put(UsuariosTable.CAMPO_ID, campoId.getText().toString());

            }
            if (campoNombre.getText().toString().equals("")) {
                toast( upsText + " Nombre");

            } else {
                values.put(UsuariosTable.CAMPO_NOMBRE, campoNombre.getText().toString());

            }
            if (campoCorreo.getText().toString().equals("")) {
                toast( upsText + " tu Correo");

            } else {

                values.put(UsuariosTable.CAMPO_CORREO, campoCorreo.getText().toString());
                Long idResultante = db.insert(UsuariosTable.TABLA_USUARIO, UsuariosTable.CAMPO_ID, values);
                toast( "No Empleado " + idResultante);
                Intent miIntento = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(miIntento);
            }

        } catch (Exception e) {

            if (campoId.getText().toString().equals("")) {
                toast( upsText + " No Empleado");

            } else if (campoNombre.getText().toString().equals("")) {
                toast( upsText + " Nombre");

            } else if (campoCorreo.getText().toString().equals("")) {
                toast( upsText + " tu Correo");

            }
        }
    }

    private void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}














