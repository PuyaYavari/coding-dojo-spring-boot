FROM adoptopenjdk:11-jdk-hotspot
EXPOSE 8080
WORKDIR /application/weather
ADD target/coding-dojo-spring-boot-1.0.0.jar /application/weather
ENTRYPOINT ["java", "-jar", "/application/weather/coding-dojo-spring-boot-1.0.0.jar"]
