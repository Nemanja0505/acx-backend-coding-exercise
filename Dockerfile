FROM maven:latest as build

USER root
RUN rm -rf /app && mkdir /app && chmod 777 /app
COPY /src /app/src
COPY pom.xml /app/pom.xml
WORKDIR /app
RUN mvn package
EXPOSE 8080

CMD [ "java", "-jar" , "target/exercise-0.0.1-SNAPSHOT.jar" ]