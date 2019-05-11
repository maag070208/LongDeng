package com.example.user.prctica8guillen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import Librerias.IntentIntegrator;
import Librerias.Parametros;

public class RegistrarFragment extends Fragment implements View.OnClickListener  {

    Spinner sp01;
    Button Ordenar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registrar, container, false);

    }
    public void onStart() {
        super.onStart();
        Ordenar= getView().findViewById(R.id.OrdenarOrd);
        sp01 = getView().findViewById(R.id.sp01);
        Ordenar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.OrdenarOrd) {
            Intent intent = new Intent(getActivity(), MenuActivity.class);
            intent.putExtra("mesa", "" + (sp01.getSelectedItemId() + 1));
            startActivity(intent);
        }

    }
}

