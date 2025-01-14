FROM openjdk:17-jdk

WORKDIR /app

COPY target/lbeauty-0.0.1-SNAPSHOT.jar lbeauty.jar

EXPOSE 443

ENTRYPOINT ["java", "-jar", "lbeauty.jar"]

