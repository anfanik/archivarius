FROM eclipse-temurin:21

COPY build/libs/archivarius.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]