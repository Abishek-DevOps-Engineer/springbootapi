FROM eclipse-temurin:21-jre
WORKDIR /usr/src/myapp
COPY target/springbootapi-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","springbootapi-0.0.1-SNAPSHOT.jar"]