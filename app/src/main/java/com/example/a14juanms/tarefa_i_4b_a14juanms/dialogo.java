package com.example.a14juanms.tarefa_i_4b_a14juanms;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by a14juanms on 10/19/15.
 */
public class dialogo extends DialogFragment {
    AlertDialog.Builder venta;
    ArrayList<String> valores = new ArrayList<>();
    boolean[]chekeados;
    String[]matriz;


    @Override
    public Dialog onCreateDialog(Bundle estado) {

        venta = new AlertDialog.Builder(getActivity());
        venta.setIcon(android.R.drawable.ic_dialog_info);
        venta.setTitle("Selecciona mamíferos");
        valores = getArguments().getStringArrayList("valor");
        chekeados= getArguments().getBooleanArray("check");
        matriz= new String[valores.size()];

        int x=0;
        for (String valor:valores){

           matriz[x]=valor;
            x++;
        }


        venta.setMultiChoiceItems(matriz, chekeados, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int opcion, boolean isChecked) {
                // Evento que ocorre cando o usuario selecciona unha opción
                if (isChecked) {
                    //Toast.makeText(getActivity(), "Seleccionaches " +matriz[opcion], Toast.LENGTH_SHORT).show();
                    chekeados[opcion] = true;

                }
                else {
                    //Toast.makeText(getActivity(), "Deseleccionaches " +matriz[opcion], Toast.LENGTH_SHORT).show();
                    chekeados[opcion]=false;
                }
            }
        });
        venta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getActivity(), "Premeches 'Aceptar'", Toast.LENGTH_SHORT).show();
            }
        });
        venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
                Toast.makeText(getActivity(), "Premeches 'Cancelar'", Toast.LENGTH_SHORT).show();
            }
        });
        return venta.create();

    }


}
