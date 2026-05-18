FROM ubuntu:latest AS build
RUN apt-get update && sudo apt-get install -y default-jdk

WORKDIR /app
COPY . .
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:latest

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]