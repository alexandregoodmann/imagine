FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} imagine.jar
ENTRYPOINT ["java","-jar","/imagine.jar"]
EXPOSE 8080
