FROM gradle:8.5-jdk17-alpine AS base
WORKDIR /app
COPY settings.gradle build.gradle ./
COPY context/shared/common/build.gradle context/shared/common/
COPY context/service/service-registry/build.gradle context/service/service-registry/

FROM base AS builder
COPY . .
RUN gradle :service-registry:build -x test --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/context/service/service-registry/build/libs/*.jar ./service-registry.jar

EXPOSE 8761
ENTRYPOINT ["java", "-jar", "service-registry.jar"]
