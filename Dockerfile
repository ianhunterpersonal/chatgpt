FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/<artifact-name>.jar <artifact-name>.jar
ENTRYPOINT ["java","-jar","<artifact-name>.jar"]
