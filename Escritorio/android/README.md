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

La pantalla principal muestra exactamente la misma experiencia que la web: navegación por secciones, formulario de reserva con confirmación y formulario de valoración con alerta. Además, tienes un botón flotante para abrir un mapa interactivo con la ubicación del hotel dentro de la propia aplicación.

## Mapa interactivo y Google Maps

La vista de mapa utiliza el SDK oficial de Google Maps para Android. Necesitas proporcionar una clave de API para que el mapa cargue correctamente:

1. Crea o reutiliza una clave de Maps en [Google Cloud Console](https://console.cloud.google.com/google/maps-apis).
2. En tu entorno local, añade la propiedad `MAPS_API_KEY` al archivo `local.properties` o ejecuta Gradle con `-PMAPS_API_KEY="tu_clave"`.
3. La clave se inyecta en el `AndroidManifest.xml` mediante `manifestPlaceholders`, así que no es necesario modificar archivos versionados.

Dentro de la app, el botón **Ver mapa** abre una pantalla nativa con un marcador sobre "Hotel Lopesan Costa Meloneras". Desde esa pantalla puedes tocar **Abrir en Google Maps** para lanzar la aplicación oficial (si está instalada) o, en su defecto, el navegador con la misma ubicación.

## Personalización

Si actualizas los contenidos de la web, solo tendrás que modificar `app/src/main/assets/index.html`.

Como el repositorio no incluye binarios, las imágenes se incrustan con data URIs dentro del HTML. Sustituye esas cadenas por tus propios datos en base64 o enlaza recursos remotos si prefieres mantener los archivos ligeros.

## Compilar desde la línea de comandos

1. Desde la raíz del repositorio ejecuta `cd Escritorio/android`.
2. Genera el wrapper con `gradle wrapper` (solo la primera vez).
3. Compila una build de depuración con `./gradlew assembleDebug`.
4. Para instalarla automáticamente en un emulador o dispositivo conectado usa `./gradlew installDebug`.

