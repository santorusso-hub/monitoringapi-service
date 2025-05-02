# Etapa 1: build com Maven e Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem leve com JDK 21
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar monitoringapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "monitoringapi-0.0.1-SNAPSHOT.jar"]
