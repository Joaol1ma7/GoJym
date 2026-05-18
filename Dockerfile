FROM ubuntu:latest AS build
RUN apt-get update && sudo apt-get install -y openjdk-25-jdk

WORKDIR /app
COPY . .
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:25-ea-1-oracle

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]