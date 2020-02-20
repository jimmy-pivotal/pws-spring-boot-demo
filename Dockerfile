FROM openjdk:11
VOLUME /tmp
COPY target/pws-spring-boot-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9090