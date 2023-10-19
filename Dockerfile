FROM openjdk:17-jdk
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} /usr/local/webapps/search.jar
ENTRYPOINT ["java","-jar","/usr/local/webapps/search.jar"]
EXPOSE 8086
