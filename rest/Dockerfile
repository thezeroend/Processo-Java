FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/rest-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]