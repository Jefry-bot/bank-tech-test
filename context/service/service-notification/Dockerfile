FROM gradle:8.5-jdk17-alpine AS base
WORKDIR /app
COPY settings.gradle build.gradle ./
COPY context/shared/common/build.gradle context/shared/common/
COPY context/service/service-notification/build.gradle context/service/service-notification/

FROM base AS builder
COPY . .
RUN gradle :service-notification:build -x test --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/context/service/service-notification/build/libs/*.jar ./service-notification.jar

ENTRYPOINT ["java", "-jar", "service-notification.jar"] 