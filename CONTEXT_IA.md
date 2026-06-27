# CONTEXTO DEL PROYECTO (Para uso de IA)
Este documento contiene la especificación completa, los casos de uso formalizados y el modelo de datos de la aplicación en desarrollo. Está diseñado para servir como memoria técnica y contexto para que cualquier Inteligencia Artificial comprenda las reglas de negocio, la arquitectura lógica y las entidades del sistema sin ambigüedades.

---

## 1. DESCRIPCIÓN GENERAL DE LA APLICACIÓN
La aplicación es una plataforma social de catalogación, seguimiento y crítica de contenido audiovisual (películas y series), fuertemente inspirada en plataformas como **Letterboxd**.

### Características principales:
- **Obtención de Catálogo:** Los datos técnicos de las películas, series, directores y actores se obtienen y sincronizan mediante una API externa de cine (como TMDB o IMDb).
- **Interacción Social:** Los usuarios pueden evaluar contenidos, escribir reseñas, comentar valoraciones de terceros, seguir a otros perfiles y crear listas temáticas dinámicas.
- **Migración Externa:** Permite importar el historial del usuario directamente desde archivos de exportación estándar (.csv) de Letterboxd.

---

## 2. CASOS DE USO FORMALIZADOS

### CU01: Autenticar Usuario
* **Actores:** Usuario de la aplicación, Servidor de Autenticación de Google (Actor secundario).
* **Descripción:** Permite a un usuario registrarse en la plataforma, iniciar sesión de forma segura (mediante credenciales tradicionales o a través de su cuenta de Google) para acceder a sus funciones personalizadas, o cerrar su sesión activa.
* **Precondiciones:** Para iniciar sesión con el método tradicional, el usuario debe haber creado una cuenta previamente.
* **Postcondiciones:** El usuario accede a su sesión activa y se le redirige al panel principal (*dashboard*).
* **Flujo Principal:**
    1. El usuario accede a la pantalla de inicio de sesión.
    2. El sistema solicita el correo electrónico y la contraseña.
    3. El usuario introduce sus credenciales y presiona "Iniciar Sesión".
    4. El sistema valida los datos introducidos con la base de datos interna.
    5. El sistema autoriza el acceso y muestra la pantalla principal con el perfil del usuario adaptado.
* **Flujos Alternativos:**
    * **Inicio de sesión con Google (OAuth2):** El usuario presiona "Iniciar sesión con Google". El sistema delega la pasarela en Google. Al recibir un token exitoso, si el correo no existe en la base de datos local, se realiza un registro automático con los datos básicos provistos.
    * **Excepción - Credenciales incorrectas:** El sistema detecta datos erróneos, muestra el mensaje *"Correo o contraseña incorrectos"* y mantiene la pantalla de acceso.

### CU02: Gestionar Valoraciones y Reseñas
* **Actores:** Usuario Autenticado.
* **Descripción:** Permite al usuario otorgar una puntuación numérica y redactar una crítica escrita sobre cualquier película o serie del catálogo.
* **Precondiciones:** Sesión activa y visualización de la ficha de una obra.
* **Postcondiciones:** La valoración y reseña se almacenan en el sistema, actualizando la nota media de la obra y mostrándose en el feed social.
* **Flujo Principal:**
    1. El usuario entra en la ficha de una obra.
    2. Selecciona una puntuación y pulsa "Escribir Reseña".
    3. El sistema habilita un cuadro de texto donde redacta su opinión y pulsa "Guardar".
    4. El sistema registra la puntuación, la reseña y actualiza el perfil del usuario.

### CU03: Gestionar Watchlist
* **Actores:** Usuario Autenticado.
* **Descripción:** Permite al usuario añadir o remover películas y series de su lista única de "Pendientes de ver".
* **Precondiciones:** Sesión activa.
* **Postcondiciones:** El estado de la obra se actualiza de forma exclusiva en la Watchlist única del usuario.
* **Flujo Principal:**
    1. El usuario entra en la ficha de una obra y presiona el botón "Añadir a Watchlist" (icono de reloj).
    2. El sistema vincula el ID de la obra con el ID del usuario en la tabla correspondiente y cambia visualmente el botón a "En tu Watchlist".

### CU04: Gestionar Listas Personalizadas
* **Actores:** Usuario Autenticado.
* **Descripción:** Permite al usuario crear agrupaciones temáticas y arbitrarias de contenidos (ej. "Películas para llorar", "Joyas ocultas"), añadiendo o quitando elementos de ellas.
* **Precondiciones:** Sesión activa.
* **Postcondiciones:** La lista personalizada se crea o modifica de manera persistente.
* **Flujo Principal:**
    1. El usuario accede a "Mis Listas", introduce obligatoriamente un título y una descripción opcional.
    2. El sistema genera la lista vacía. El usuario utiliza el buscador integrado para seleccionar obras y añadirlas a esta lista específica.

### CU05: Gestionar Red Social
* **Actores:** Usuario Autenticado.
* **Descripción:** Permite la interacción comunitaria mediante el seguimiento entre usuarios e interacciones como "Me gusta" y comentarios en reseñas ajenas.
* **Precondiciones:** Sesión activa.
* **Postcondiciones:** Las interacciones se registran de manera persistente en la base de datos social.

### CU06: Importar Datos de Letterboxd
* **Actores:** Usuario Autenticado.
* **Descripción:** Permite al usuario migrar su historial previo subiendo el archivo de exportación estándar (.csv) de Letterboxd.
* **Precondiciones:** Sesión activa y archivo .csv válido.
* **Flujo Principal:** El sistema procesa el archivo fila por fila, mapea los identificadores externos (IMDb/TMDB), busca la coincidencia en el catálogo y recrea automáticamente el historial de películas vistas, notas y Watchlist en la aplicación.

### CU07: Obtener Catálogo
* **Actores:** Usuario (Autenticado/Anónimo), API Externa (Actor de soporte).
* **Descripción:** Permite consultar los detalles de las películas y series sincronizadas en tiempo real desde un servicio externo de cine.
* **Flujo Principal:** El usuario introduce un término de búsqueda; el sistema realiza una petición HTTP estructurada a la API externa, procesa la respuesta JSON (títulos, directores, pósters) y renderiza los resultados.

---

## 3. MODELO CONCEPTUAL DE DATOS (Basado en Diagrama Técnico)

A continuación se detalla la estructura física y lógica de las tablas según el modelo conceptual establecido en la arquitectura del sistema:

### Entidades y Atributos:

1. **Usuario**
    - `Id` (Clave Primaria)
    - `Nombre`
    - `Contraseña` (Almacenada como hash)
    - `Email`
    - `Telefono`

2. **Rol**
    - `Id` (Clave Primaria)
    - `Nom` (Nombre del rol, ej: Administrador, Usuario Estándar)
      *Relación:* Un **Usuario** *Se clasifica* en un **Rol** (Relación de muchos a uno: M:1).

3. **Dirección**
    - `País`
    - `Ciudad`
    - `Provincia`
    - `Calle`
      *Relación:* Un **Usuario** *Vive* en una **Dirección** (Relación lógica mapeada en el diagrama).

4. **Obras** (Películas y Series)
    - `Id` (Clave Primaria)
    - `Nombre`
    - `Descripción_Corta`
    - `Descripción_Larga`
    - `Fecha`
    - `Director`

5. **Valoración** (Entidad asociativa de la relación *Puntua*)
    - `Id` (Clave Primaria)
    - `Puntuación` (Escala numérica o estrellas)
    - `Descripción` (Texto de la crítica/reseña)
    - `id_Usuario` (Clave Foránea a Usuario)
    - `id_Obra` (Clave Foránea a Obras)
      *Relación:* Un **Usuario** *Puntua* muchas **Obras** a través de esta entidad intermedia.

6. **Actor**
    - `id` (Clave Primaria)
    - `Nombre`
    - `Descripción`
    - `Edad`
      *Relación:* Los actores *Participan* en muchas **Obras** y una obra tiene muchos actores (Relación de muchos a muchos: M:N).

7. **Plataforma** (Servicios de Streaming donde está disponible)
    - `id` (Clave Primaria)
    - `Nombre`
    - `Precio`
      *Relación:* Las obras *Se ven* en una o más **Plataformas** (Relación de muchos a muchos: M:N).

8. **Lista** (Agrupaciones Temáticas / Watchlist)
    - `id` (Clave Primaria)
    - `Titulo`
      *Relación:* Una **Lista** contiene/agrega de forma lógica múltiples **Obras** (Relación de agregación representada en el diagrama).

---

## 4. INSTRUCCIONES PARA LA IA
Cuando trabajes sobre este código, interfaz o base de datos, debes respetar obligatoriamente las siguientes directrices:
1. **Separación de Listas:** Una `Lista` genérica (creada por el usuario) y la `Watchlist` comparten comportamiento estructural (contienen colecciones de `Obras`), pero la Watchlist es única por usuario y responde a un flujo rápido exclusivo (CU03).
2. **Sincronización Externa:** La tabla de `Obras` guarda de forma local los datos mínimos consumidos desde la API externa para optimizar el rendimiento y poder vincular las entidades locales (`Valoración`, `Actor`, `Plataforma`).
3. **Seguridad en Autenticación:** El atributo `Contraseña` de la entidad `Usuario` nunca debe manejarse en texto plano; siempre debe procesarse mediante algoritmos de hash seguros (ej. bcrypt). El inicio de sesión por Google genera usuarios saltándose la validación interna de contraseña.