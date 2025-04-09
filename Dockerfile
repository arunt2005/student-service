# Stage 1: Build the JAR
FROM gradle:8.5-jdk21 AS builder

WORKDIR /app
COPY . .

# ✅ Fix permission issue for gradlew
RUN chmod +x ./gradlew

# Build the Spring Boot JAR
RUN ./gradlew clean bootJar

# Stage 2: Run the app
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/student-service-*.jar app.jar

EXPOSE 1000

ENTRYPOINT ["java", "-jar", "app.jar"]
