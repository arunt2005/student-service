# Use Java 21 base image
FROM eclipse-temurin:21-jdk

# Maintainer info (optional)
LABEL maintainer="your-name"

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY student-service-1.jar app.jar

# Expose the application port
EXPOSE 1000

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
