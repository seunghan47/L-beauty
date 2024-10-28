FROM openjdk:17-jdk

WORKDIR /app

COPY target/lbeauty-0.0.1-SNAPSHOT.jar lbeauty.jar
 
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "lbeauty.jar"]

