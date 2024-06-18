# Primera etapa: Construcción usando una imagen base que incluye el JDK
FROM openjdk:17-slim AS build

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto Maven
COPY pom.xml .
COPY src ./src

# Descarga todas las dependencias necesarias y compila el proyecto
RUN mvn dependency:go-offline -B && mvn package -DskipTests

# Segunda etapa: Ejecución usando JRE
FROM openjdk:17

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR compilado desde la primera etapa
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que la aplicación utilizará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
