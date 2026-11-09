Manual Técnico y Tutorial de Creación: Front-End Móvil
**Proyecto:** GualiTutor (Fase 3)  
**Asignatura:** Programación 2 — Universidad Mariano Gálvez de Guatemala  
**Catedrático:** Ing. MGSI. César Hernández  

1. Prerrequisitos y Software Necesario

Para el desarrollo y compilación de la aplicación móvil cliente **GualiTutor**, se requiere el siguiente entorno de desarrollo:

- **Java Development Kit (JDK):** Versión 17 o superior.
- **Android Studio:** Versión Jellyfish / Ladybug (o posterior) con soporte para API 24 (Android 7.0 Nougat) en adelante.
- **Android Virtual Device (AVD):** Emulador configurado con un perfil de hardware *Medium Phone* rodando API 34 o 37.

2. Proceso de Instalación y Configuración del Entorno

Paso 2.1: Instalación de Android Studio
1. Descargar el ejecutable oficial desde el portal de desarrolladores de Android.
2. Iniciar el asistente de instalación (*Setup Wizard*), seleccionando las opciones por defecto para componentes SDK y emulador.

<img width="636" height="486" alt="image" src="https://github.com/user-attachments/assets/f98408ed-647b-452f-80a5-c4f89657ae3e" />


Paso 2.2: Configuración del SDK Manager
1. Abrir Android Studio y navegar a `Settings > Languages & Frameworks > Android SDK`.
2. En la pestaña **SDK Platforms**, seleccionar el paquete **Android 17.0 ("CinnamonBun") / API 37** o API 34.
3. Hacer clic en `Apply` y `OK` para descargar e instalar los paquetes necesarios.

Paso 2.3: Configuración del Dispositivo Virtual (AVD)
1. Abrir el **Device Manager** desde la barra lateral derecha o menú superior.
2. Crear un nuevo dispositivo virtual (*Create Virtual Device*), seleccionando la categoría **Phone** y el perfil **Medium Phone**.
3. Seleccionar la System Image correspondiente a la API instalada y presionar **Finish**.

3. Creación del Front-End (Interfaz Principal)

La interfaz se estructuró dividiendo la vista en XML y la lógica de control en Java.

Paso 3.1: Diseño de la Interfaz Visual (`activity_main.xml`)
El archivo de diseño `activity_main.xml` contiene un contenedor principal `LinearLayout` vertical que aloja los siguientes componentes:
- `Spinner` (`spinnerLecciones`): Selector desplegable del listado de lecciones.
- `ImageView` (`imgLeccion`): Visor dinámico para la ilustración gráfica de la lección.
- `TextView` (`txtContenido`): Área textual explicativa con el contenido conceptual.
- `Button` (`btnCompletar` / `btnPendiente`): Botones de acción para registrar el progreso.
  
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout android:layout_height="match_parent" android:layout_width="match_parent" android:orientation="vertical" android:padding="16dp" xmlns:android="[http://schemas.android.com/apk/res/android](http://schemas.android.com/apk/res/android)">

    <TextView android:gravity="center" android:layout_height="wrap_content" android:layout_width="match_parent" android:paddingBottom="12dp" android:text="GualiTutor - Lecciones" android:textSize="20sp" android:textStyle="bold"/>

    <Spinner android:id="@+id/spinnerLecciones" android:layout_height="wrap_content" android:layout_width="match_parent" android:minHeight="48dp"/>

    <ImageView android:id="@+id/imgLeccion" android:layout_height="200dp" android:layout_marginTop="12dp" android:layout_width="match_parent" android:scaleType="fitCenter"/>

    <TextView android:id="@+id/txtContenido" android:layout_height="0dp" android:layout_marginTop="12dp" android:layout_weight="1" android:layout_width="match_parent" android:textSize="14sp"/>

    <LinearLayout android:layout_height="wrap_content" android:layout_width="match_parent" android:orientation="horizontal">

        <Button android:id="@+id/btnCompletar" android:layout_height="wrap_content" android:layout_weight="1" android:layout_width="0dp" android:text="Completada"/>

        <Button android:id="@+id/btnPendiente" android:layout_height="wrap_content" android:layout_weight="1" android:layout_width="0dp" android:text="Pendiente"/>
    </LinearLayout>
</LinearLayout>
```

Paso 3.2: Lógica de Control (MainActivity.java)
En la clase MainActivity.java se implementó la vinculación de vistas, el poblado de datos a través de un ArrayAdapter y los oyentes de eventos (Listeners):
```java
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
                        txtContenido.setText("Bienvenido a la Introducción a Java.\n\nJava es un lenguaje de programación orientado a objetos, portable y seguro.");
                        imgLeccion.setImageResource(android.R.drawable.ic_menu_compass);
                        break;
                    case 1:
                        txtContenido.setText("Estructuras de Control en Java:\n\n- Sentencias condicionales: if, else, switch.\n- Bucles: for, while, do-while.");
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

        btnCompletar.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, 
                spinnerLecciones.getSelectedItem().toString() + " -> Marcada como Completada", 
                Toast.LENGTH_SHORT).show()
        );

        btnPendiente.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, 
                spinnerLecciones.getSelectedItem().toString() + " -> Marcada como Pendiente", 
                Toast.LENGTH_SHORT).show()
        );
    }
}
```
4. Pruebas de Ejecución y Evidencias de Funcionamiento
4.1 Carga Inicial y Navegación entre Lecciones
Al seleccionar Lección 1 o Lección 2 en el menú desplegable Spinner, la aplicación actualiza automáticamente la imagen superior y el texto explicativo inferior.
<img width="564" height="628" alt="image" src="https://github.com/user-attachments/assets/a29ce997-76b4-4f42-9df0-f9722b2f7615" />


4.2 Evaluación de Eventos y Notificaciones Toast
Al presionar el botón Completada estando en la Lección 3: Programación Orientada a Objetos, se ejecuta el evento que despliega la notificación Toast en la parte inferior de la pantalla.


<img width="272" height="628" alt="image" src="https://github.com/user-attachments/assets/e6fc5b59-3138-4524-81a0-9db279507d1d" />



