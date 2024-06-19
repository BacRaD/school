FROM openjdk:24-jdk-slim
WORKDIR $APP_HOME
COPY target/school-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]