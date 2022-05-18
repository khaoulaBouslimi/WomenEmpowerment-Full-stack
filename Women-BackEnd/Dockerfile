FROM openjdk:11
ADD target/p2a.jar p2a.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","/p2a.jar"]

#FROM maven:3.8.2-jdk-11

#WORKDIR /
#COPY . .
#RUN mvn clean install

#CMD mvn spring-boot:run
