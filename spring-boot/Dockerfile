FROM openjdk:alpine

MAINTAINER Pavol Loffay <ploffay@redhat.com>

ENV APP_HOME /app/

COPY target/demo-opentracing-0.0.1-SNAPSHOT.jar $APP_HOME

#COPY pom.xml $APP_HOME
#COPY src $APP_HOME/src
#COPY .mvn $APP_HOME/.mvn
#COPY mvnw $APP_HOME

WORKDIR $APP_HOME
#RUN ./mvnw package -Dlicense.skip=true && rm -rf ~/.m2

EXPOSE 8080

# set env variables when starting the container
CMD java -jar demo-opentracing-0.0.1-SNAPSHOT.jar
