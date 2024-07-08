FROM maven:3.8-openjdk-17-slim AS build

ENV PROJECT_NAME=veda-source-java
# workdir
WORKDIR /${PROJECT_NAME}
COPY . .
# cache dependency
RUN --mount=type=cache,target=/root/.m2 mvn clean install -pl veda-cms -T 1C -U -Dmaven.compile.fork=true -Dmaven.test.skip -Dorg.slf4j.simpleLogger.defaultLogLevel=warn -B -X

FROM openjdk:17-jdk-slim

MAINTAINER bruno
ARG APP_VERSION
ENV PROJECT_NAME=veda-source-cms-java
# workdir
WORKDIR /${PROJECT_NAME}
COPY --from=build /${PROJECT_NAME}/veda-cms/target/veda-cms-0.0.1-SNAPSHOT.jar /${PROJECT_NAME}/app.jar

ENTRYPOINT ["sh","-c", "java -jar /${PROJECT_NAME}/app.jar --spring.profiles.active=${ENV}" ]
