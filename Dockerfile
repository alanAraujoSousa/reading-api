FROM openjdk:8
ADD target/reading-api.jar reading-api.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "reading-api.jar"]