FROM alpine:edge
RUN apk --no-cache add openjdk17
VOLUME /tmp
COPY target/interaction-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]