FROM openjdk:11-jdk
VOLUME /tmp
ADD target/display-parameters-server-spring-boot.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]