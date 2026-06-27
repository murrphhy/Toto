# =============================================================================
# Stage 1: BUILD — compila el módulo :server en un fat jar
# =============================================================================
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copiamos el proyecto entero (el .dockerignore excluye build/, .gradle, .idea, iosApp, etc.)
# Hace falta el proyecto completo porque settings.gradle.kts referencia todos los módulos.
COPY . .

RUN chmod +x gradlew

# Construye SOLO el server.
#  --configure-on-demand  -> NO configura :androidApp ni :shared, así NO necesita el Android SDK
#  --no-configuration-cache -> evita conflictos con el config-cache del proyecto
#  --no-daemon            -> en CI/Docker no tiene sentido dejar daemon vivo
RUN ./gradlew :server:buildFatJar --no-daemon --no-configuration-cache --configure-on-demand

# =============================================================================
# Stage 2: RUNTIME — imagen ligera con solo el JRE + el jar
# =============================================================================
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app

# El plugin de Ktor genera el fat jar como "server-all.jar" en build/libs
COPY --from=build /app/server/build/libs/*-all.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
