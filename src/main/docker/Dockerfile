FROM openjdk:8

VOLUME /temporary
ADD maven/spring-boot-credit-rest-with-docker-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
#In nutshell => Entrypoint says: run our jar!
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]