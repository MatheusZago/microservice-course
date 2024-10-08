#Criando container do Docker
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app
#COPIANDO TODO O PROJETO PARA O CONTAINER
COPY . .
RUN mvn clean package -DskipTests



#Arquivo para criar uma imagem docker
FROM openjdk:11
WORKDIR /app
#Vai copiar o jar que vai ser geraod do build para o jar da iamgem
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761

#Argumentos para que sejam usados dinamicamente na conexão
ARG EUREKA_SERVER=locahost

ENTRYPOINT java -jar -Dspring.profiles.active=production app.jar