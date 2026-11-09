Manual Técnico y Tutorial de Creación del Front-End Móvil
Proyecto: GualiTutor --- Fase 3
Asignatura: Programación 2 --- Universidad Mariano Gálvez de
Guatemala
Catedrático: Ing. MGSI. César Hernández
1. Prerrequisitos y software necesario
Para desarrollar y ejecutar la aplicación móvil cliente GualiTutor
se necesita contar con un entorno de desarrollo Android configurado
correctamente.
Requisitos
- Computadora con Windows, Linux o macOS.
- Android Studio instalado.
- Un JDK compatible con Android Studio y Gradle.
- Android SDK instalado.
- Un dispositivo físico Android o un Android Virtual Device (AVD).
Configuración del proyecto
De acuerdo con la configuración real del proyecto:
- compileSdk: 37
- targetSdk: 37
- minSdk: 24
- Compatibilidad del código fuente: Java 11
- Application ID: com.example.gualitutormobile
El valor minSdk = 24 indica que la aplicación está configurada para
Android 7.0 (API 24) o superior.
Importante: El proyecto está configurado para compilar el código
fuente con Java 11. Esto no significa necesariamente que la versión
del JDK utilizada por Android Studio deba ser exactamente 11; Android
Studio/Gradle puede utilizar un JDK compatible más reciente.

2. Proceso de instalación y configuración del entorno
2.1 Instalación de Android Studio
1. Descargar Android Studio desde el sitio oficial de Android
   Developers.
2. Ejecutar el instalador.
3. Seguir las instrucciones del asistente de instalación.
4. Mantener las opciones recomendadas para instalar Android Studio y
   los componentes necesarios del SDK.
5. Finalizar la instalación.
6. Abrir Android Studio.

Evidencia: La siguiente captura muestra el proceso/pantalla de
instalación utilizada como referencia para el entorno.


<img width="1100" height="864" alt="image" src="https://github.com/user-attachments/assets/7d3663a4-5b02-4b0c-b104-29298a93a7d0" />

2.2 Configuración del SDK Manager
1. Abrir Android Studio.
2. Ir a Tools → SDK Manager.
3. En SDK Platforms, verificar que esté disponible la plataforma
   Android API 37, utilizada por este proyecto.
4. En SDK Tools, verificar las herramientas necesarias para
   compilar y ejecutar aplicaciones Android.
5. Si algún componente no está instalado, seleccionarlo y presionar
   Apply.
6. Esperar a que finalice la instalación y presionar OK.
   2.3 Configuración del dispositivo virtual (AVD)
Para ejecutar la aplicación se puede utilizar un dispositivo virtual de
Android.
1. Abrir Tools → Device Manager.
2. Seleccionar Create Virtual Device.
3. Elegir la categoría Phone.
4. Seleccionar un perfil de dispositivo, por ejemplo Medium Phone,
   si está disponible.
5. Elegir una imagen del sistema compatible con el SDK instalado.
6. Presionar Finish para crear el dispositivo.
7. Iniciar el dispositivo desde Device Manager.

3. Creación del Front-End
La aplicación separa la interfaz visual, desarrollada mediante XML, de
la lógica de interacción, desarrollada mediante Java.
3.1 Diseño de la interfaz visual (activity_main.xml)La interfaz utiliza un LinearLayout vertical como contenedor principal
y contiene los siguientes elementos:
- TextView: muestra el título GualiTutor - Lecciones.
- Spinner (spinnerLecciones): permite seleccionar una lección.
- ImageView (imgLeccion): muestra una imagen relacionada con la
  lección.
- ScrollView: permite desplazarse por el contenido cuando sea
  necesario.
- TextView (txtContenido): muestra la información de la lección.
- Button (btnCompletar): permite marcar la lección como
  completada.
- Button (btnPendiente): permite marcar la lección como pendiente.
El archivo se encuentra en:
app > src > main > res > layout > activity_main.xml



<img width="1907" height="1012" alt="image" src="https://github.com/user-attachments/assets/5ceffb59-21c2-4ae0-8aa9-bb19d33cd9dc" />


Código de activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:background="#F5F5F5">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="GualiTutor - Lecciones"
        android:textSize="22sp"
        android:textStyle="bold"
        android:textColor="#333333"
        android:layout_gravity="center"
        android:layout_marginBottom="16dp" />

    <Spinner
        android:id="@+id/spinnerLecciones"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginBottom="16dp"
        android:background="@android:drawable/btn_dropdown" />

    <ImageView
        android:id="@+id/imgLeccion"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:scaleType="fitCenter"
        android:contentDescription="Imagen de la lección"
        android:background="#E0E0E0"
        android:layout_marginBottom="16dp" />

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="#FFFFFF"
        android:padding="12dp">

        <TextView
            android:id="@+id/txtContenido"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Selecciona una lección para ver su contenido..."
            android:textSize="16sp"
            android:textColor="#444444" />
    </ScrollView>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="16dp"
        android:weightSum="2">

        <Button
            android:id="@+id/btnCompletar"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Completada"
            android:layout_marginEnd="8dp"
            android:backgroundTint="#4CAF50" />

        <Button
            android:id="@+id/btnPendiente"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Pendiente"
            android:backgroundTint="#FF9800" />
    </LinearLayout>

</LinearLayout>

3.2 Lógica de control (MainActivity.java)
El archivo se encuentra en:
app > src > main > java > com.example.gualitutormobile > MainActivity.java

En esta clase se realizan las siguientes acciones:
1. Se enlazan los componentes de la interfaz mediante findViewById.
2. Se crea una lista con tres lecciones.
3. Se utiliza un ArrayAdapter para mostrar las lecciones en el
   Spinner.
4. Se detecta la lección seleccionada.
5. Se actualizan el contenido y la imagen según la opción seleccionada.
6. Se configura el botón Completada.
7. Se configura el botón Pendiente.
8. Se muestran mensajes Toast para informar al usuario sobre la
   acción realizada.

   Código de MainActivity.java
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

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        lecciones);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinnerLecciones.setAdapter(adapter);

        spinnerLecciones.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {

                switch (position) {
                    case 0:
                        txtContenido.setText(
                                "Bienvenido a la Introducción a Java.

" +
                                "Java es un lenguaje de programación " +
                                "orientado a objetos, portable y seguro. " +
                                "Se utiliza ampliamente en desarrollo " +
                                "backend y móvil.");

                        imgLeccion.setImageResource(
                                android.R.drawable.ic_menu_compass);
                        break;

                    case 1:
                        txtContenido.setText(
                                "Estructuras de Control en Java:

" +
                                "- Sentencias condicionales: if, else, switch.
" +
                                "- Bucles: for, while, do-while.

" +
                                "Permiten controlar el flujo de ejecución " +
                                "del programa.");

                        imgLeccion.setImageResource(
                                android.R.drawable.ic_menu_agenda);
                        break;

                    case 2:
                        txtContenido.setText(
                                "Programación Orientada a Objetos (POO):

" +
                                "- Clases y Objetos
" +
                                "- Encapsulamiento
" +
                                "- Herencia
" +
                                "- Polimorfismo");

                        imgLeccion.setImageResource(
                                android.R.drawable.ic_menu_manage);
                        break;
                }
            }

            @Override
            public void onNothingSelected(
                    AdapterView<?> parent) {
            }
        });

        btnCompletar.setOnClickListener(v -> {
            String leccionSel =
                    spinnerLecciones.getSelectedItem().toString();

            Toast.makeText(
                    MainActivity.this,
                    leccionSel + " -> Marcada como Completada",
                    Toast.LENGTH_LONG
            ).show();
        });

        btnPendiente.setOnClickListener(v -> {
            String leccionSel =
                    spinnerLecciones.getSelectedItem().toString();

            Toast.makeText(
                    MainActivity.this,
                    leccionSel + " -> Marcada como Pendiente",
                    Toast.LENGTH_LONG
            ).show();
        });
    }
}
4. Ejecución y pruebas de funcionamiento
4.1 Ejecución de la aplicación
Para ejecutar el proyecto:
1. Iniciar el AVD desde Device Manager, o conectar un dispositivo
   Android.
2. Esperar a que el dispositivo esté disponible.
3. En Android Studio seleccionar el dispositivo de ejecución.
4. Presionar el botón Run ▶.
5. Esperar a que Gradle compile el proyecto.
6. La aplicación se instalará y abrirá en el dispositivo seleccionado.
Figura 5. Aplicación GualiTutor ejecutándose correctamente en el emulador Medium Phone API 37.0.

<img width="498" height="930" alt="image" src="https://github.com/user-attachments/assets/ea7d072e-f3fc-431a-8fd4-fb1298699009" />




4.2 Carga inicial y navegación entre lecciones
La aplicación muestra un menú desplegable con tres opciones:
1. Lección 1: Introducción a Java
2. Lección 2: Estructuras de Control
3. Lección 3: Programación Orientada a Objetos
Al seleccionar una lección, se actualizan automáticamente el contenido
textual y la imagen correspondiente.

<img width="352" height="786" alt="image" src="https://github.com/user-attachments/assets/34af519a-671b-49ea-a857-d733a347d7b6" />


4.3 Evaluación de los botones y notificaciones Toast
Al presionar el botón Completada, la aplicación obtiene la lección
seleccionada y muestra un mensaje indicando que fue marcada como
completada.


<img width="363" height="793" alt="image" src="https://github.com/user-attachments/assets/8936b3dc-d2ba-4463-b1ac-bdafe04af681" />




<img width="356" height="787" alt="image" src="https://github.com/user-attachments/assets/503e454a-11d7-4ee0-ab85-9044f2bfc014" />




De igual manera, al presionar Pendiente, se muestra un mensaje
indicando que la lección fue marcada como pendiente.

La siguiente evidencia muestra una prueba del evento Completada:

5. Resultado final
Al finalizar el desarrollo se obtiene una aplicación móvil funcional que
permite:
- Seleccionar una lección desde un menú desplegable.
- Mostrar información diferente según la lección seleccionada.
- Mostrar una imagen relacionada con cada lección.
- Marcar una lección como Completada.
- Marcar una lección como Pendiente.
- Mostrar mensajes de confirmación mediante Toast.

La aplicación móvil GualiTutor fue desarrollada correctamente utilizando Android Studio y Java. El front-end permite al usuario seleccionar diferentes lecciones mediante un Spinner, visualizar el contenido correspondiente y cambiar el estado de cada lección mediante los botones “Completada” y “Pendiente”.

Las pruebas realizadas permitieron comprobar el correcto funcionamiento de la interfaz, la selección de lecciones y los mensajes de confirmación. La aplicación se ejecuta correctamente en un emulador Android con API 37.


  <img width="350" height="788" alt="image" src="https://github.com/user-attachments/assets/f3ff3b0a-34b1-450d-8ab5-92a865874a80" />


  6. Estructura principal del proyecto
La estructura principal del proyecto es:

GualiTutorMobile/
├── app/
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/
│           │   └── com/example/gualitutormobile/
│           │       └── MainActivity.java
│           └── res/
│               └── layout/
│                   └── activity_main.xml
├── build.gradle.kts
├── gradle.properties
├── gradlew
└── settings.gradle.kts
Los archivos principales del Front-End son:
- activity_main.xml: define la estructura visual.
- MainActivity.java: controla la interacción y el comportamiento de
  la interfaz.

  
<img width="1907" height="1008" alt="image" src="https://github.com/user-attachments/assets/21a2f299-d996-4279-becb-d77579c03b26" />


  7. Repositorio del proyecto
El tutorial en formato Markdown y el proyecto deben estar disponibles en
un repositorio público de GitHub.

Repositorio:

https://github.com/sofiaelias112007-boop/GualiTutor-Fase3

Se recomienda incluir en el repositorio el código fuente necesario para
abrir y compilar el proyecto de Android Studio.

No es necesario subir carpetas generadas automáticamente, como .gradle
o archivos locales de configuración.

8. Conclusión
La creación del Front-End de GualiTutor permitió aplicar conocimientos
de desarrollo de aplicaciones Android mediante Android Studio,
utilizando XML para construir la interfaz y Java para implementar la
lógica de interacción.

La aplicación permite seleccionar diferentes lecciones, visualizar su
contenido e imagen correspondiente y registrar de manera sencilla si una
lección se encuentra completada o pendiente.

El proyecto queda preparado para continuar con futuras etapas de
desarrollo e integración de nuevas funcionalidades.
