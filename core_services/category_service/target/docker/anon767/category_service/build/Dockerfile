FROM openjdk:8-jre-alpine
EXPOSE 10100
COPY maven /
RUN sh -c 'touch /app.jar'
VOLUME ["/tmp"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
