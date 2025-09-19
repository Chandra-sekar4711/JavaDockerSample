# Use Java base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the JAR file from the target folder to the container
COPY target/Basic-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
