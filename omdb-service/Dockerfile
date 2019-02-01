FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/omdb-service*.jar omdb-service.jar
CMD java ${JAVA_OPTS} -jar omdb-service.jar