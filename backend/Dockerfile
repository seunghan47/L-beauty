FROM openjdk:17-jdk

WORKDIR /app

COPY target/lbeauty.jar lbeauty.jar
 
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "lbeauty.jar"]

