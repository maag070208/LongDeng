package com.example.user.prctica8guillen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Librerias.IntentIntegrator;
import Librerias.IntentResult;
import Librerias.Parametros;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager manipuladorFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        manipuladorFragmentos = getSupportFragmentManager();
        manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new PortadaFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_portada) {
            manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new PortadaFragment()).commit();

        } else if (id == R.id.nav_registrar) {

            manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new RegistrarFragment()).commit();

        } else if (id == R.id.nav_modificar) {

            manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new ModificarFragment()).commit();

        } else if (id == R.id.nav_eliminar) {

            manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new EliminarFragment()).commit();


        } else if (id == R.id.nav_inventario) {

            manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new InventarioFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (Parametros.escaneo == true) {
            IntentResult resultadoEscaneo = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            if (resultadoEscaneo != null) {
                String contenidoScaneo = resultadoEscaneo.getContents();
                Parametros.codigo = contenidoScaneo;
            } else {
                Toast.makeText(getApplicationContext(), "Valor no Leido", Toast.LENGTH_SHORT).show();
        }

    }else if(Parametros.camara) {
            if (intent!= null)
                if(intent.hasExtra("data")) {
                    Parametros.imagen = (Bitmap) intent.getParcelableExtra("data");
                }
        } else if (Parametros.galeria) {
        Uri imagenSeleccionada = intent.getData();
        InputStream entrada;
        try {
            entrada = getContentResolver().openInputStream(imagenSeleccionada);
            BufferedInputStream lector = new BufferedInputStream(entrada);
            Parametros.imagen=BitmapFactory.decodeStream(lector);
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Error en la imagen", Toast.LENGTH_SHORT).show();
        }
    }
}
    public void fragmentoMostrar(String titulo){
            if(titulo.equals("registrar")){
                manipuladorFragmentos.beginTransaction().replace(R.id.Paginador, new PortadaFragment()).commit();
            }
        }
}
