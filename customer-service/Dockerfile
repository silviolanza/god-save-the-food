FROM maven:2.7.8-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM openjdk:8-alpine
RUN addgroup -S spring && adduser -S spring -G spring
VOLUME /tmp
EXPOSE 8080
ARG DEPENDENCY=target
ADD ${DEPENDENCY}/*.jar customergsf.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customergsf.jar"]
