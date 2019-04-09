FROM openjdk:8-jre
MAINTAINER thank coderthank@163.com

COPY target/*.jar eureka.jar

#EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/eureka.jar"]