FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} search.jar
ENTRYPOINT ["java","-jar","search.jar"]
EXPOSE 8086
