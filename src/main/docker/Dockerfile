FROM openjdk:8

VOLUME /temp
ADD maven/simple_credit_microservices-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
#In nutshell => Entrypoint says: run our jar!
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]