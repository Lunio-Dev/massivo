# Etapa de construção
FROM ubuntu:latest AS build

# Atualizar pacotes e instalar dependências
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copiar o código fonte para o contêiner
COPY . .

# Definir o diretório de trabalho e construir o projeto
WORKDIR /app
RUN mvn clean install

# Exibir os arquivos no diretório target para depuração
RUN ls -la target

# Etapa de execução
FROM openjdk:17-jdk

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR da etapa de construção para o contêiner
COPY --from=build /app/target/massivo-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
