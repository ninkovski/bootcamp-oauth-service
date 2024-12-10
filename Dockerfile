# Usamos una imagen de OpenJDK como base
FROM openjdk:17-jdk-slim

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo .jar de tu aplicación dentro del contenedor
COPY target/oauth-service-0.0.1-SNAPSHOT.jar oauthservice.jar

# Exponemos el puerto en el que la aplicación escucha
EXPOSE 8000

# Comando para ejecutar el archivo .jar
ENTRYPOINT ["java", "-jar", "oauthservice.jar"]