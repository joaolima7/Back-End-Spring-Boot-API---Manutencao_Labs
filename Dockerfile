From maven:3.9.6-amazoncorretto-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:21-ea-10-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./manutencaolabsSpring.jar
ENTRYPOINT java -jar manutencaolabsSpring.jar