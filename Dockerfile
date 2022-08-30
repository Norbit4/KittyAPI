FROM eclipse-temurin:11-jre-alpine
ARG JAR_FILE=build/libs/KittyAPI-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]