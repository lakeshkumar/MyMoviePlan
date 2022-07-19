FROM openjdk:11
ADD target/*.jar MyMoviePlan-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/MyMoviePlan-0.0.1-SNAPSHOT.jar"]
