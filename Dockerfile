FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
COPY target/calculator-1.0.jar /calculator.jar
CMD ["java", "-jar", "/calculator.jar"]
