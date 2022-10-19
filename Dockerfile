FROM openjdk:11.0.16-jdk as build-image
WORKDIR /app
COPY . .
RUN ./mvnw clean package

FROM openjdk:11.0.16-jre
COPY --from=build-image /app/target/*jar .
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]