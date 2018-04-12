FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/app.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT sleep 5 && java $JAVA_OPTS -jar /app.jar