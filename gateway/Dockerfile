FROM openjdk:8-jre
MAINTAINER thank coderthank@163.com

ADD target/*.jar gateway.jar

#EXPOSE 8050

ENTRYPOINT ["java", "-jar", "/gateway.jar", "--spring.profiles.active=prod"]
