FROM openjdk:26-ea-17-slim
WORKDIR /usr/app
COPY ./target/transfer-service-0.0.1-SNAPSHOT.jar /usr/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "transfer-service-0.0.1-SNAPSHOT.jar"]