# Establece la imagen base
FROM openjdk:11-jdk-slim as build

# Instala curl y Maven
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz | tar xz -C /opt && \
    ln -s /opt/apache-maven-3.6.3 /opt/maven

# Establece variables de entorno para Maven
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y los archivos de código fuente al directorio de trabajo
COPY pom.xml .
COPY src ./src

# Descarga todas las dependencias necesarias y empaqueta la aplicación
RUN mvn dependency:go-offline -B && mvn package -DskipTests

# Segunda etapa del build para minimizar el tamaño de la imagen final
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo en esta nueva etapa
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción a la etapa de ejecución
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que tu aplicación utilizará
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]



# Instala curl y Maven
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz | tar xz -C /opt && \
    ln -s /opt/apache-maven-3.6.3 /opt/maven

# Establece variables de entorno para Maven
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y los archivos de código fuente al directorio de trabajo
COPY pom.xml .
COPY src ./src

# Descarga todas las dependencias necesarias y empaqueta la aplicación
RUN mvn dependency:go-offline -B && mvn package -DskipTests

# Segunda etapa del build para minimizar el tamaño de la imagen final
FROM openjdk:17-jre-slim

# Establece el directorio de trabajo en esta nueva etapa
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción a la etapa de ejecución
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que tu aplicación utilizará
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]



# Instala Maven y otras herramientas necesarias
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz | tar xz -C /opt && \
    ln -s /opt/apache-maven-3.6.3 /opt/maven

# Establece variables de entorno para Maven
ENV MAVEN_HOME /opt/maven
ENV PATH $MAVEN_HOME/bin:$PATH

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y los archivos de código fuente al directorio de trabajo
COPY pom.xml .
COPY src ./src

# Descarga todas las dependencias necesarias y empaqueta la aplicación
RUN mvn dependency:go-offline -B && mvn package -DskipTests

# Segunda etapa del build para minimizar el tamaño de la imagen final
FROM openjdk:17-jre-slim

# Establece el directorio de trabajo en esta nueva etapa
WORKDIR /app

# Copia el archivo JAR desde la etapa de construcción a la etapa de ejecución
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto que tu aplicación utilizará
EXPOSE 8080

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:17-slim as build...
FROM openjdk:17-slim
