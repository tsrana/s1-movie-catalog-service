#
# Build stage
#
FROM maven:3.6.3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/app/target/s1-movie-catalog-service-0.0.1-SNAPSHOT.jar /usr/local/lib/tsrana.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/usr/local/lib/tsrana.jar"]





#FROM openjdk:8
#ADD target/s1-movie-catalog-service-0.0.1-SNAPSHOT.jar s1-movie-catalog-service-0.0.1-SNAPSHOT.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "s1-movie-catalog-service-0.0.1-SNAPSHOT.jar"]