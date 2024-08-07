# Etapa de construção
FROM ubuntu:latest AS build

# Instalar dependências e ferramentas necessárias
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven && \
    rm -rf /var/lib/apt/lists/*

# Definir diretório de trabalho
WORKDIR /app

# Copiar todos os arquivos para o contêiner de construção
COPY . .

# Construir a aplicação
RUN mvn clean install

# Etapa final: usar a imagem base oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta necessária
EXPOSE 8080

# Copiar o arquivo JAR da etapa de construção
COPY --from=build /app/target/massivo-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
