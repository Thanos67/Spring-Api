FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar spring-api.jar
ENTRYPOINT ["java","-jar","/spring-api.jar"]