# Use Eclipse Temurin Java 17 (production-ready, actively maintained)
FROM eclipse-temurin:17-jre-jammy

# Set working directory inside the container
WORKDIR /app

# Copy Maven build output (jar) into container
COPY target/*.jar app.jar

# Expose application port (adjust if your app uses another port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]