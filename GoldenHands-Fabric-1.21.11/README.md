# Golden Hands — Fabric 1.21.11

Proyecto Java para Minecraft **1.21.11**, Fabric y Java 21. Incluye GitHub Actions para intentar compilar el mod automáticamente cada vez que subas cambios.

> **Importante:** este proyecto es un punto de partida y todavía no se ha verificado una compilación completa en este entorno. El workflow mostrará cualquier error de compilación en GitHub Actions. La función de contorno/brillo dorado no está implementada todavía.

## Compilar en GitHub

1. Entra en https://github.com/new y crea un repositorio nuevo, por ejemplo `GoldenHands-Fabric-1.21.11`.
2. Descomprime este ZIP en tu PC.
3. Sube **el contenido de la carpeta** `GoldenHands-Fabric-1.21.11` al repositorio (incluida la carpeta oculta `.github`). Puedes usar **Add file → Upload files** o GitHub Desktop.
4. Abre la pestaña **Actions** del repositorio. El workflow **Build Golden Hands** se ejecutará al subir los archivos. Si GitHub pide habilitar Actions, habilítalo.
5. Cuando termine, abre la ejecución más reciente. Si sale verde, baja el archivo desde **Artifacts → GoldenHands-Fabric-1.21.11**.
6. Descomprime el artifact descargado y copia el `.jar` dentro de la carpeta `mods` de tu perfil Fabric 1.21.11.

## Compilar localmente (opcional)

Necesitas Java 21 y Gradle 8.14.3 instalados. Desde esta carpeta ejecuta:

```bash
gradle --no-daemon build
```

El JAR se genera en `build/libs/`.

## Estado actual

- Configuración inicial para Fabric 1.21.11 / Java 21.
- Workflow de GitHub Actions para compilar y publicar el JAR como artifact de la ejecución.
- La colocación de manos/objetos y el renderizado todavía necesitan probarse dentro del juego; no se garantiza que esta versión inicial funcione sin ajustes.
