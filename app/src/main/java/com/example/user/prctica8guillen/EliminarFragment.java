package com.example.user.prctica8guillen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import Librerias.IntentIntegrator;
import Librerias.Parametros;

public class EliminarFragment extends Fragment implements View.OnClickListener{


    Button Menu;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eliminar, container, false);
    }

    public void onStart() {
        super.onStart();

        Menu = (Button) getView().findViewById(R.id.MenuEliminar);
        Menu.setOnClickListener(this);
        }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.MenuEliminar) {
            Intent intent = new Intent(getActivity(), MenuActivity.class);
            getActivity().startActivity(intent);

        }
    }
}
