FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . .
RUN mvn -q -DskipTests -pl mscloudgateway -am clean package
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/mscloudgateway/target/*.jar /app/app.jar
ENV EUREKA_SERVER=eurekaserver
ENV KEYCLOAK_SERVER=keycloak
ENV KEYCLOAK_PORT=8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app/app.jar"]