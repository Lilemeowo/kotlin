# kotlin

🍰 1000 Sabores – Pastelería & Tienda

1000 Sabores es una aplicación móvil desarrollada en Kotlin + Jetpack Compose, pensada para una experiencia de compra simple y moderna en Android.
Permite gestionar productos, carrito, perfil de usuario con persistencia local y sucursales.

👥 Equipo de Desarrollo

Matías Pulgar – Desarrollador

Proyecto académico para Duoc UC en la asignatura de Desarrollo de Aplicaciones Móviles.

💡 Descripción del Proyecto

La app 1000 Sabores ofrece una experiencia de compra para pastelería: catálogo de productos, carrito con cálculo de total + IVA, y perfil de usuario con almacenamiento local.
Las pantallas están conectadas con Navigation Compose y el estado de la UI se gestiona con MVVM (ViewModel + Flow).

🚀 Funcionalidades Principales

🔐 Acceso y perfil con validación
Formulario con campos y mensajes de error; soporte para foto de perfil (cámara).

🏠 Menú principal
Hub de navegación hacia Productos, Carrito, Perfil y Sucursales.

🧁 Gestión de productos
Catálogo con nombre, precio y descripción; agregar al carrito.

🛒 Carrito de compras
Agregar/quitar/limpiar; cálculo de subtotal y total con IVA (19%).

👤 Perfil de usuario (persistencia local)
Guarda nombre, email y dirección con DataStore.

🏬 Sucursales
Listado con dirección, horario y teléfono.

🎨 Diseño Material 3
Interfaz moderna; tema claro/oscuro y tipografías MD3.

(Opcional a futuro): abrir mapa/llamada desde Sucursales.

🛠️ Tecnologías Utilizadas

Lenguaje: Kotlin

UI: Jetpack Compose (Material 3)

Arquitectura: MVVM (ViewModel + StateFlow)

Navegación: Navigation Compose

Almacenamiento local: DataStore (Preferences)

IDE: Android Studio

compileSdk: 36 · minSdk: 24

📂 Estructura del Proyecto
app/src/main/java/com/example/a1000sabores/
├─ MainActivity.kt                      // setContent + Theme + Nav
├─ data/
│  ├─ Datosusuarios.kt                  // DataStore (perfil/órdenes)
│  ├─ Productos.kt                      // Datos estáticos de productos
│  └─ Sucursales.kt                     // Datos estáticos de sucursales
├─ ui/
│  ├─ components/
│  │  ├─ BotonMenu.kt                   // Composable reutilizable
│  │  └─ SucursalCard.kt                // Card para sucursales
│  ├─ navigation/
│  │  ├─ NavRoutes.kt                   // Rutas
│  │  └─ appNav.kt                      // NavHost con destinos
│  ├─ screens/
│  │  ├─ LoginScreen.kt
│  │  ├─ MenuScreen.kt
│  │  ├─ ProductosScreen.kt
│  │  ├─ CarritoScreen.kt
│  │  ├─ PerfilScreen.kt
│  │  └─ SucursalesScreen.kt
│  ├─ theme/
│  │  ├─ Color.kt  ├─ Shape.kt  ├─ Theme.kt  └─ Type.kt
│  └─ viewmodel/
│     └─ AppViewModel.kt                // Estado y lógica de UI (carrito/perfil)

💻 Cómo ejecutar el proyecto
Opción A — Proyecto local (carpeta/zip)

Descomprime el proyecto y abre Android Studio.

File → Open… y selecciona la carpeta del módulo 1000sabores.

Espera la sincronización de Gradle.

Crea un emulador (API 36) o conecta un dispositivo con depuración USB.

Clic en Run ▶️.
