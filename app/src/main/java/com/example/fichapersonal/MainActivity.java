package com.example.fichapersonal;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    Button btnNombre;
    Button btnCurso;
    Button btnLenguaje;
    AlertDialog.Builder cuadroNombre;
    TextView tvNombre;

    AlertDialog.Builder cuadroLenguaje;



    AlertDialog.Builder cuadroCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] listaCurso=new String[] {"DAM", "DAW", "ASIR"};
        final String[] listaLenguaje=new String[] {"JAVA", "C", "Python"};
        final int[] checkedItems={-1};
        final boolean[] checkedItems2 = new boolean[listaLenguaje.length];

        tvNombre=findViewById(R.id.txNombre);
        btnNombre= findViewById(R.id.btnNombre);
        btnCurso=findViewById(R.id.btnCurso);
        btnLenguaje=findViewById(R.id.btnLenguaje);

        final View layoutNombre=getLayoutInflater().inflate(R.layout.cuadronombre,null);
        cuadroNombre=new AlertDialog.Builder(MainActivity.this);
        EditText nombre=layoutNombre.findViewById(R.id.edtNombre);

        cuadroNombre.setCancelable(true);
        cuadroNombre.setTitle("Tu nombre");
        cuadroNombre.setView(layoutNombre);
        cuadroNombre.setNegativeButton("Cancelar", null);
        cuadroNombre.setPositiveButton("Aceptar",((dialog, which) -> {



            tvNombre.setText(nombre.getText().toString());
        }));

        cuadroCurso=new AlertDialog.Builder(MainActivity.this);
        cuadroCurso.setSingleChoiceItems(listaCurso, checkedItems[0], (dialog, which)->{

            String cursoSeleccionado= listaCurso[which];
            TextView hola=findViewById(R.id.txCurso);
            hola.setText(cursoSeleccionado);

        });
        cuadroCurso.setNegativeButton("Cancelar", null);
        cuadroCurso.setPositiveButton("Aceptar", (dialog, which) -> {
        });



        cuadroLenguaje=new AlertDialog.Builder(MainActivity.this);

        cuadroLenguaje.setNegativeButton("Cancelar", null );



       cuadroLenguaje.setMultiChoiceItems(listaLenguaje, checkedItems2, (dialog, which, isChecked)-> {

            String lenguajeSeleccionado=listaLenguaje[which];
            TextView txsi=findViewById(R.id.txLenguaje);

            txsi.setText(lenguajeSeleccionado);
        });
        cuadroLenguaje.setPositiveButton("Aceptar", (dialog, which) -> {
        });
        btnNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cuadroNombre.create();
                cuadroNombre.show();
            }
        });

        btnCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuadroCurso.create();
                cuadroCurso.show();
            }
        });

        btnLenguaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuadroLenguaje.create();
                cuadroLenguaje.show();
            }
        });
    }



}