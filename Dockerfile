FROM artifacts.it.bancobai.ao/eclipse-temurin:21.0.2_13-jdk-alpine AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw

RUN ./mvnw clean install package

FROM artifacts.it.bancobai.ao/eclipse-temurin:21.0.2_13-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/monitoringapi-0.0.1-SNAPSHOT.jar /app

EXPOSE 2026

ENV JAVA_OPTS="-Xms200m -Xmx2g -XX:+UseG1GC"

CMD ["sh", "-c", "java $JAVA_OPTS -jar monitoringapi-0.0.1-SNAPSHOT.jar"]
