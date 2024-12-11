FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copiar el archivo JAR generado al contenedor
COPY target/oauth-service-0.0.1-SNAPSHOT app.jar
# Exponer el puerto que usa tu aplicación (por defecto es 8080)
EXPOSE 8000
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]