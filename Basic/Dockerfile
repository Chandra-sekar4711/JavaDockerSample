# Use OpenJDK 17 slim base image
FROM openjdk:17-slim

# Set working directory inside the container
WORKDIR /app

# Copy Maven build output (jar) into container
COPY target/*.jar app.jar

# Expose application port (adjust if your app uses another port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]