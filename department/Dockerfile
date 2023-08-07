FROM openjdk:17
VOLUME /temp
EXPOSE 8079
ARG JAR_FILE=build/libs/department-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} department.jar
ENTRYPOINT ["java","-jar","/department.jar"]