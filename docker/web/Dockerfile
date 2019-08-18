FROM openjdk:10-jre-slim
COPY ./target/shortener-0.0.1-SNAPSHOT.jar /usr/shortener.jar
RUN pwd
RUN ls -lah
workdir /usr
entrypoint "java" "-jar" "shortener.jar"