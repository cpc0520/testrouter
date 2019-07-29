FROM openjdk:8-alpine

COPY target/uberjar/testrouter.jar /testrouter/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/testrouter/app.jar"]
