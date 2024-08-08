FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install
RUN ls -la target


FROM openjdk:17-jdk

# Diretório de trabalho dentro do contêiner
WORKDIR /massivo/src/io/lunio/massivo

EXPOSE 8080
# Copiar o arquivo JAR para o contêiner
COPY --from=build/target/massivo-0.0.1-SNAPSHOT.jar

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]