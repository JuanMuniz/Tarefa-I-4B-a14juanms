package com.example.a14juanms.tarefa_i_4b_a14juanms;

/*Baseándose nun cadro de diálogo con Selección Múltiple (showDialog) realiza a tarefa I-4B-Username.

        1.- Activity principal:

        Botón (showDialog): que chama ao cadro de diálogo de selección múltiple
        Botón (dialogFragment): que chame ao cadro de diálogo de selección múltiple
        TextView: que amose os ítems seleccionados no cadro de diálogo cando o usuario preme Aceptar no cadro.
        Cadro de diálogo de selección múltiple:
        Debe amosar una lista de elementos que o usuario pode seleccionar (algúns poden estar xa marcados por defecto).

        2.- Facer que a lista de selección sexa dinámica, para iso engadir á activity anterior:

        EditText onde introducir elementos na lista.
        Botón para engadir elementos á lista*/


import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class tarefa_1_4_B_a14juanms extends FragmentActivity {

    ArrayList<String>valores=new ArrayList<>();
    dialogo dialogoF=new dialogo();
    Button btnShow;
    Button btnDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_1_4__b_a14juanms);
        btnShow= (Button)findViewById(R.id.botonShow);
        btnDia= (Button)findViewById(R.id.botonDia);
        valores.add("Perro");
        valores.add("Gato");
        valores.add("Conejo");
        valores.add("Zorro");
        valores.add("Mapache");
    }
    
    
    
    public void callD(View v){
        
    }

    public void callDialog(View v){
        callFragment();
    }

    
    public void callFragment(){
        Bundle feixe=new Bundle();
        feixe.putStringArrayList("valor",valores);
        dialogoF.setArguments(feixe);
        dialogoF.show(getFragmentManager(), "");
    }
}
