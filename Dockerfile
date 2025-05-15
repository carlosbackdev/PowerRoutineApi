# Usa una imagen base de Maven para compilar la aplicación
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copia los archivos de configuración y el código fuente
COPY pom.xml .
COPY src ./src

# Compila la aplicación
RUN mvn clean package -DskipTests

# Usa una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app


# Copia el archivo JAR generado desde la etapa de compilación
COPY --from=build /app/target/PowerRoutine-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]