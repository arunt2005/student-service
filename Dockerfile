# Use Java 21 base image
FROM eclipse-temurin:21-jdk

LABEL maintainer="your-name"

WORKDIR /app

# Copy dynamically named JAR from build output
COPY build/libs/student-service-*.jar app.jar

EXPOSE 1000

ENTRYPOINT ["java", "-jar", "app.jar"]
