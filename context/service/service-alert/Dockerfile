FROM gradle:8.5-jdk17-alpine AS base
WORKDIR /app
COPY settings.gradle build.gradle ./
COPY context/shared/common/build.gradle context/shared/common/
COPY context/service/service-alert/build.gradle context/service/service-alert/

FROM base AS builder
COPY . .
RUN gradle :service-alert:build -x test --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/context/service/service-alert/build/libs/*.jar ./service-alert.jar

ENTRYPOINT ["java", "-jar", "service-alert.jar"]