FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/movie-list-service*.jar movie-list-service.jar
CMD java ${JAVA_OPTS} -jar movie-list-service.jar