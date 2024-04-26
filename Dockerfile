FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/ToDO-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8093

CMD ["java", "-jar", "/app/app.jar"]
