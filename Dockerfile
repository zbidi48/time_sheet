FROM openjdk:8-jdk-alpine
WORKDIR C/Users/ASUS/.jenkins/workspace/TimeSheet/time_sheet
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
