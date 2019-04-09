FROM openjdk:8-jre
MAINTAINER thank coderthank@163.com

ADD target/*.jar cloudlink-user.jar

#EXPOSE 8901

ENTRYPOINT ["java", "-jar", "/cloudlink-user.jar", "--spring.profiles.active=prod"]
