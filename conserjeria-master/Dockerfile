# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build your application using Gradle
RUN ./gradlew build

# Make port 7070 available to the world outside this container
EXPOSE 7070

# Run your application when the container launches
CMD ["./gradlew", "run"]