FROM openjdk:21-jdk-slim
COPY . /app
WORKDIR /app
CMD ["java", "-jar", "target/gold-movie-API.jar"]
