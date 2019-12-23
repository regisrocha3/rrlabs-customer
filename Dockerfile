FROM adoptopenjdk/openjdk13:latest
EXPOSE 8080
VOLUME /home/regis/app/

COPY ./cassandra.properties ./
COPY ./ ./

ADD /target/rrlabs-customer-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
