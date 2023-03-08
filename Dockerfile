FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/Tiker-1.0-SNAPSHOT.jar /Tiker.jar
CMD ["echo", "start run jar"]
ENTRYPOINT ["java", "jar", "/Tiker.jar", "&"]