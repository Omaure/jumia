FROM adoptopenjdk/openjdk11
EXPOSE 8088
COPY target/jumia-0.0.1-SNAPSHOT.jar app.jar
COPY sample.db sample.db
ENTRYPOINT ["java","-jar","/app.jar"]