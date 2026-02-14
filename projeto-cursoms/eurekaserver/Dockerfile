FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . .
RUN mvn -q -DskipTests -pl eurekaserver -am clean package
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/eurekaserver/target/*.jar /app/app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app/app.jar"]