FROM openjdk:11
ADD target/s1-movie-catalog-service-0.0.1-SNAPSHOT.jar s1-movie-catalog-service-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "s1-movie-catalog-service-0.0.1-SNAPSHOT.jar"]