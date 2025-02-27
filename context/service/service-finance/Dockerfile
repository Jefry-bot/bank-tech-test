FROM gradle:8.5-jdk17-alpine AS base
WORKDIR /app
COPY settings.gradle build.gradle ./
COPY context/shared/common/build.gradle context/shared/common/
COPY context/service/service-finance/build.gradle context/service/service-finance/

FROM base AS builder
COPY . .
RUN gradle :service-finance:build -x test --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/context/service/service-finance/build/libs/*.jar ./service-finance.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "service-finance.jar"] 