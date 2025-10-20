# Aplicación iPad - Hotel Lopesan Costa Meloneras

Este proyecto de Xcode utiliza SwiftUI y un `WKWebView` para mostrar la misma página HTML presente en la carpeta `Pagina Marketing`. Los recursos se empaquetan en la aplicación para que funcione sin conexión y mantenga la experiencia visual original.

## Requisitos

- Xcode 15 o superior
- macOS con soporte para desarrollo de iOS/iPadOS

## Puesta en marcha

1. Abre Xcode y selecciona **Open a project or file**.
2. Navega hasta `Escritorio/ipad/HotelLopesanIPad.xcodeproj` y ábrelo.
3. Elige un simulador de iPad o un dispositivo físico y pulsa **Run**.

El `ContentView` carga automáticamente `Resources/index.html` desde el bundle de la aplicación, reproduciendo el menú, formularios y estilos originales.

## Actualización de contenidos

Para actualizar la información del hotel solo debes editar los archivos HTML dentro de `HotelLopesanIPad/Resources/` y volver a compilar.

Las imágenes se incrustan como data URIs para evitar binarios en el repositorio. Sustituye la cadena base64 por tus propios datos o carga recursos remotos si necesitas otro material gráfico.

## Compilar desde la línea de comandos

Para automatizar la compilación puedes usar `xcodebuild`:

```bash
cd Escritorio/ipad
xcodebuild -scheme HotelLopesanIPad -destination 'platform=iOS Simulator,name=iPad (10th generation)' build
```

Cambia el destino por el identificador de tu dispositivo físico (`-destination "platform=iOS,id=..."`) si quieres desplegar en hardware real.

## Icono de la app

El repositorio no incluye imágenes binarias. Si quieres un icono personalizado, añade tus recursos en `Assets.xcassets` y asigna su nombre en el apartado **App Icons and Launch Images** del proyecto.

