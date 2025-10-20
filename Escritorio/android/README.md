# Aplicación Android - Hotel Lopesan Costa Meloneras

Esta carpeta contiene un proyecto de Android Studio que envuelve la página web existente del hotel dentro de una `WebView`. El contenido HTML es el mismo que encontrarás en la carpeta original `Pagina Marketing` y se entrega de forma local para que funcione sin conexión.

## Requisitos

- Android Studio Iguana o superior
- JDK 17
- Gradle 8.7 (Android Studio descargará el wrapper automáticamente si ejecutas **Sync Project with Gradle Files**)

## Puesta en marcha

1. Abre Android Studio y selecciona **Open an Existing Project**.
2. Elige la carpeta `Escritorio/android`.
3. Cuando Android Studio te lo pida, permite que genere el wrapper de Gradle (o ejecútalo manualmente con `gradle wrapper`).
4. Sincroniza el proyecto y ejecútalo en un emulador o dispositivo físico Android.

La pantalla principal muestra exactamente la misma experiencia que la web: navegación por secciones, formulario de reserva con confirmación y formulario de valoración con alerta.

## Personalización

Si actualizas los contenidos de la web, solo tendrás que modificar `app/src/main/assets/index.html`.

Como el repositorio no incluye binarios, las imágenes se incrustan con data URIs dentro del HTML. Sustituye esas cadenas por tus propios datos en base64 o enlaza recursos remotos si prefieres mantener los archivos ligeros.

## Compilar desde la línea de comandos

1. Desde la raíz del repositorio ejecuta `cd Escritorio/android`.
2. Genera el wrapper con `gradle wrapper` (solo la primera vez).
3. Compila una build de depuración con `./gradlew assembleDebug`.
4. Para instalarla automáticamente en un emulador o dispositivo conectado usa `./gradlew installDebug`.

