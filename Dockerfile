# image base of OpenJDK for Java 21
FROM openjdk:21-jdk-slim

VOLUME [ "/data" ]

# copy the jar file to the container
COPY ./target/library-api-0.0.1-SNAPSHOT.jar /library-api.jar

# port that the application will run
EXPOSE 8080

# command to run the application
ENTRYPOINT ["java", "-jar", "library-api.jar"]