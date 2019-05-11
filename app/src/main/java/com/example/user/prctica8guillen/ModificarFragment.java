package com.example.user.prctica8guillen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import Librerias.IntentIntegrator;
import Librerias.Parametros;

public class ModificarFragment extends Fragment implements View.OnClickListener {

    Button mesa_1, mesa_2, mesa_3, mesa_4, mesa_5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_modificar, container, false);
    }

    public void onStart() {
        super.onStart();

        mesa_1 = (Button) getView().findViewById(R.id.Mesa_1Mesas);
        mesa_1.setOnClickListener(this);

        mesa_2 = (Button) getView().findViewById(R.id.Mesa_2Mesas);
        mesa_2.setOnClickListener(this);

        mesa_3 = (Button) getView().findViewById(R.id.Mesa_3Mesas);
        mesa_3.setOnClickListener(this);

        mesa_4 = (Button) getView().findViewById(R.id.Mesa_4Mesas);
        mesa_4.setOnClickListener(this);

        mesa_5 = (Button) getView().findViewById(R.id.Mesa_5Mesas);
        mesa_5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String tituloMesa = "Mesa ";

        switch (v.getId()) {
            case R.id.Mesa_1Mesas:
                tituloMesa += "1";
                break;
            case R.id.Mesa_2Mesas:
                tituloMesa += "2";
                break;
            case R.id.Mesa_3Mesas:
                tituloMesa += "3";
                break;
            case R.id.Mesa_4Mesas:
                tituloMesa += "4";
                break;
            case R.id.Mesa_5Mesas:
                tituloMesa += "5";
                break;
        }

        Intent intent = new Intent(getActivity(), MesaActivity.class);
        intent.putExtra("titulo_mesa", tituloMesa);
        startActivity(intent);
    }
}
