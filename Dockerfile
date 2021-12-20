FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
ADD build/libs/cloud-0.0.1-SNAPSHOT.jar /app/config.jar
EXPOSE 3254
ENTRYPOINT ["java", "-jar", "/app/config.jar"]
