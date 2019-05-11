package com.example.user.prctica8guillen;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.prctica8guillen.Entidades.Orden;
import com.example.user.prctica8guillen.Utilidades.OrdenTable;

public class MenuActivity extends AppCompatActivity {

    LinearLayout pollo_cantones;

    String mesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                mesa = extras.getString("mesa");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        pollo_cantones = findViewById(R.id.pollo_cantones);
        pollo_cantones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orden orden = new Orden("Pollito cantones", "Pollo cantones",
                        60, Integer.parseInt(mesa));

                agregarOrden(orden);
            }
        });
    }

    public void agregarOrden(Orden orden) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(OrdenTable.CAMPO_DESCRIPCION, orden.getDescripcion());
        // TODO Agregar los values.put correspondintes
    }
}
