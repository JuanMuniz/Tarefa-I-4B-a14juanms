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


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tarefa_1_4_B_a14juanms extends FragmentActivity {

    static final int numeroDialogo = 1;
    ArrayList<String> valores = new ArrayList<>();
    ArrayList<Boolean> chekeados = new ArrayList<>();
    dialogo dialogoF = new dialogo();
    Button btnShow;
    Button btnDia;
    TextView verMamiferos;
    EditText engadeMamiferos;
    Button engadir;
    AlertDialog.Builder venta;
    boolean chekeadositems[];
    String matriz[];
    String seleccionados;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_1_4__b_a14juanms);
        btnShow = (Button) findViewById(R.id.botonShow);
        btnDia = (Button) findViewById(R.id.botonDia);
        verMamiferos = (TextView) findViewById(R.id.itemSelected);
        engadeMamiferos = (EditText) findViewById(R.id.engadeMamifero);
        engadir = (Button) findViewById(R.id.btnEngadir);

        valores.add("Perro");
        chekeados.add(false);
        valores.add("Gato");
        chekeados.add(false);
        valores.add("Conejo");
        chekeados.add(false);
        valores.add("Zorro");
        chekeados.add(true);
        valores.add("Mapache");
        chekeados.add(false);

        //Listener para o boton de showDialog
        btnShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                onCreateDialog(numeroDialogo);
                showDialog(numeroDialogo);

            }
        });
    }

    public void engadirAnimal(View v) {
        if (!engadeMamiferos.getText().toString().equals("")) {
            valores.add(engadeMamiferos.getText().toString());
            chekeados.add(false);
            engadeMamiferos.setText("");
            

        } else {
            Toast.makeText(getApplicationContext(), " Escribe mamífero ", Toast.LENGTH_SHORT).show();
        }
    }


    public void callDialog(View v) {
        callFragment();
    }


    public void callFragment() {
        Bundle feixe = new Bundle();
        feixe.putStringArrayList("valor", valores);
        boolean[] buleanos = new boolean[valores.size()];
        int i = 0;
        for (Boolean checked : chekeados) {
            buleanos[i] = checked;
            i++;
        }
        feixe.putBooleanArray("check", buleanos);
        dialogoF.setArguments(feixe);
        dialogoF.show(getFragmentManager(), "");

    }

    protected Dialog onCreateDialog(int id) {

        verMamiferos.setText("");
        seleccionados = "";
        venta = new AlertDialog.Builder(this);
        venta.setIcon(android.R.drawable.ic_dialog_info);
        venta.setTitle("Selecciona mamíferos");

        matriz = new String[valores.size()];
        chekeadositems = new boolean[valores.size()];
        int x = 0;
        for (String valor : valores) {

            matriz[x] = valor;
            x++;
        }

        int i = 0;
        for (boolean item : chekeados) {

            chekeadositems[i] = item;
            i++;
        }

        venta.setMultiChoiceItems(matriz, chekeadositems, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                // Evento que ocorre cando o usuario selecciona unha opción
                if (isChecked) {

                    chekeadositems[opcion] = true;

                } else {

                    chekeadositems[opcion] = false;
                }
            }
        });
        venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getBaseContext(), "Premeches 'Aceptar'", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < chekeadositems.length; i++) {
                    if (chekeadositems[i]) seleccionados = seleccionados + matriz[i] + " ";
                }
                verMamiferos.setText(seleccionados);
            }
        });
        venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getBaseContext(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
            }
        });
        return venta.create();

    }


}



