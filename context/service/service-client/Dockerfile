FROM gradle:8.5-jdk17-alpine AS base
WORKDIR /app
COPY settings.gradle build.gradle ./
COPY context/shared/common/build.gradle context/shared/common/
COPY context/service/service-client/build.gradle context/service/service-client/

FROM base AS builder
COPY . .
RUN gradle :service-client:build -x test --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/context/service/service-client/build/libs/*.jar ./service-client.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "service-client.jar"] 