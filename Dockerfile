FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER root
VOLUME /tmp
ADD db.mv.db  /tmp/db.mv.db
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN /bin/sh -c "apk add --no-cache bash"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]