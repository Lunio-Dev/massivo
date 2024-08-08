FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY target/massivo-0.0.1-SNAPSHOT.jar /

RUN apt-get install maven -y
RUN mvn clean install
RUN ls -la target

# Use a imagem base oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /main

EXPOSE 8080

# Copia o arquivo JAR para o contêiner
COPY target/massivo-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
