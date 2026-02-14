FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . .
RUN mvn -q -DskipTests -pl mscartoes -am clean package
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/mscartoes/target/*.jar /app/app.jar
ENV RABBITMQ_SERVER=rabbitmq
ENV EUREKA_SERVER=eurekaserver
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app/app.jar"]