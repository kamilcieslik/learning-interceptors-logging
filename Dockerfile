FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} learning_interceptors.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/learning_interceptors.jar"]