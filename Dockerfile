FROM openjdk:8
EXPOSE 8093
ADD target/Spring-Boot-Neo4j-0.0.1-SNAPSHOT.jar Spring-Boot-Neo4j-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Spring-Boot-Neo4j-0.0.1-SNAPSHOT.jar"]