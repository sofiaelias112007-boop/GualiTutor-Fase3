# Tutorial de Creación de la Interfaz Móvil - GualiTutor (Fase 3)

1. Prerrequisitos y Software Necesario
Para la creación de esta aplicación móvil se utilizó el siguiente entorno de desarrollo:
- **Java Development Kit (JDK):** Versión 17 o superior.
- **Android Studio:** Versión Jellyfish / Ladybug (o posterior) con compatibilidad para API 24 (Android 7.0) en adelante.
- **Android Virtual Device (AVD):** Emulador configurado con API 34/37 (ej. Medium Phone).

Proceso de Instalación:
1. Descargar e instalar Android Studio desde el sitio oficial.
2. Configurar el SDK Manager seleccionando **Android SDK Platform** para la versión requerida.
3. Crear un emulador virtual desde el **Device Manager** en Android Studio.


2. Creación del Front-End (Interfaz Principal)

### Paso 1: Diseño de la Interfaz (activity_main.xml)
El diseño principal se construyó usando componentes de UI estándar de Android:
- `Spinner` para la selección dinámica de lecciones.
- `ImageView` para mostrar el contenido gráfico de la lección activa.
- `TextView` para el contenido explicativo de la lección.
- `Button` para interactuar y marcar el estado ("Completada" o "Pendiente").

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout android:layout_height="match_parent" android:layout_width="match_parent" android:orientation="vertical" android:padding="16dp" xmlns:android="[http://schemas.android.com/apk/res/android](http://schemas.android.com/apk/res/android)">

    <TextView android:gravity="center" android:layout_height="wrap_wrap" android:layout_width="match_parent" android:paddingBottom="12dp" android:text="GualiTutor - Lecciones" android:textSize="20sp" android:textStyle="bold"/>

    <Spinner android:id="@+id/spinnerLecciones" android:layout_height="wrap_content" android:layout_width="match_parent" android:minHeight="48dp"/>

    <ImageView android:id="@+id/imgLeccion" android:layout_height="200dp" android:layout_marginTop="12dp" android:layout_width="match_parent" android:scaleType="fitCenter"/>

    <TextView android:id="@+id/txtContenido" android:layout_height="0dp" android:layout_marginTop="12dp" android:layout_weight="1" android:layout_width="match_parent" android:textSize="14sp"/>

    <LinearLayout android:layout_height="wrap_content" android:layout_width="match_parent" android:orientation="horizontal">

        <Button android:id="@+id/btnCompletar" android:layout_height="wrap_content" android:layout_weight="1" android:layout_width="0dp" android:text="Completada"/>

        <Button android:id="@+id/btnPendiente" android:layout_height="wrap_content" android:layout_weight="1" android:layout_width="0dp" android:text="Pendiente"/>
    </LinearLayout>
</LinearLayout>
