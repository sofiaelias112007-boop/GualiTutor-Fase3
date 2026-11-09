package com.example.gualitutormobile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerLecciones;
    private ImageView imgLeccion;
    private TextView txtContenido;
    private Button btnCompletar, btnPendiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerLecciones = findViewById(R.id.spinnerLecciones);
        imgLeccion = findViewById(R.id.imgLeccion);
        txtContenido = findViewById(R.id.txtContenido);
        btnCompletar = findViewById(R.id.btnCompletar);
        btnPendiente = findViewById(R.id.btnPendiente);


        List<String> lecciones = new ArrayList<>();
        lecciones.add("Lección 1: Introducción a Java");
        lecciones.add("Lección 2: Estructuras de Control");
        lecciones.add("Lección 3: Programación Orientada a Objetos");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lecciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLecciones.setAdapter(adapter);


        spinnerLecciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        txtContenido.setText("Bienvenido a la Introducción a Java.\n\nJava es un lenguaje de programación orientado a objetos, portable y seguro. Se utiliza ampliamente en desarrollo backend y móvil.");
                        imgLeccion.setImageResource(android.R.drawable.ic_menu_compass);
                        break;
                    case 1:
                        txtContenido.setText("Estructuras de Control en Java:\n\n- Sentencias condicionales: if, else, switch.\n- Bucles: for, while, do-while.\n\nPermiten controlar el flujo de ejecución del programa.");
                        imgLeccion.setImageResource(android.R.drawable.ic_menu_agenda);
                        break;
                    case 2:
                        txtContenido.setText("Programación Orientada a Objetos (POO):\n\n- Clases y Objetos\n- Encapsulamiento\n- Herencia\n- Polimorfismo");
                        imgLeccion.setImageResource(android.R.drawable.ic_menu_manage);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        btnCompletar.setOnClickListener(v -> {
            String leccionSel = spinnerLecciones.getSelectedItem().toString();
            Toast.makeText(MainActivity.this, leccionSel + " -> Marcada como Completada", Toast.LENGTH_LONG).show();
        });

        btnPendiente.setOnClickListener(v -> {
            String leccionSel = spinnerLecciones.getSelectedItem().toString();
            Toast.makeText(MainActivity.this, leccionSel + " -> Marcada como Pendiente", Toast.LENGTH_LONG).show();
        });
    }
}