# Usa una imagen base de OpenJDK con JRE optimizado
FROM openjdk:17-jdk-slim

# Crea un directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor

COPY target/usuario-service-0.0.1-SNAPSHOT.jar app.jar

# Recibe argumentos para la imagen
ARG APP_PORT=8080
ARG MONGO_URI=mongouser:mongopass@localhost:27017/mongodb
#ARG MONGO_USER=mongouser
#ARG MONGO_PASS=mongopass
#ARG MONGO_HOST=localhost
#ARG MONGO_PORT=27017
#ARG MONGO_DB=mongodb

# Establece variables de entorno predeterminadas (puedes sobrescribirlas al iniciar el contenedor)
ENV SPRING_PROFILES_ACTIVE=prod
ENV APP_PORT=$APP_PORT
ENV MONGO_URI=$MONGO_URI
#ENV MONGO_USER=$MONGO_USER
#ENV MONGO_PASS=$MONGO_PASS
#ENV MONGO_HOST=$MONGO_HOST
#ENV MONGO_PORT=$MONGO_PORT
#ENV MONGO_DB=$MONGO_DB
#ENV SPRING_PROFILES_ACTIVE=prod
#ENV SPRING_DATA_MONGODB_URI=mongodb://usuario:contraseña@host:puerto/nombre_base_datos

# Expone el puerto en el que se ejecuta la aplicación
EXPOSE $APP_PORT

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

