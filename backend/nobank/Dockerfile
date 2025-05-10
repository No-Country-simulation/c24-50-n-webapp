FROM amazoncorretto:17.0.14-alpine
ARG JAR_FILE=target/nobank-0.0.1.jar
COPY ${JAR_FILE} app_nobank.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_nobank.jar"]
