package com.example.user.prctica8guillen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import Librerias.Productos;
import Librerias.ProductosAdapter;

public class MesaActivity extends AppCompatActivity {
    int[] imagenes = {R.drawable.cafesito, R.drawable.limpiador, R.drawable.galletas};
    String[] descripcion = {"cafe del bueno", "limpia todo", "galletitas"};
    String[] codigo = {"43265", "73477", "4734",};
    int[] precio = {20, 12, 15};

    ListView lista;
    ProductosAdapter adaptador;
    TextView tituloMesa;

    private String titulo_mesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesa);

        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                titulo_mesa = extras.getString("titulo_mesa");
            }
        }
    }

    public void onStart() {
        super.onStart();
        tituloMesa = findViewById(R.id.tituloMesa);
        tituloMesa.setText(titulo_mesa);

        lista = findViewById(R.id.listaMesa1);
        adaptador = new ProductosAdapter(getApplicationContext());
        for (int x = 0; x < imagenes.length; x++) {
            adaptador.add(new Productos(codigo[x], descripcion[x], precio[x], imagenes[x]));
        }
        adaptador.notifyDataSetChanged();
        lista.setAdapter(adaptador);
    }
}
