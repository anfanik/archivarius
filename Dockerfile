FROM openjdk:22-jdk-alpine

COPY build/libs/archivarius.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]