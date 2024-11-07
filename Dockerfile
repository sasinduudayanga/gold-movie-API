FROM eclipse-temurin:21

WORKDIR /app
COPY ./target/movies-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "movies-0.0.1-SNAPSHOT.jar"]