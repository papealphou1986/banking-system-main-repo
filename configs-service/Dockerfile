FROM openjdk:17-oracle
LABEL authors="Alphousseyni Mané"
VOLUME /tmp
COPY target/*.jar  /app/configs-service.jar
ENTRYPOINT ["java", "-jar", "/app/configs-service.jar"]