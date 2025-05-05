FROM eclipse-temurin:21
WORKDIR /opt/app
COPY target/*.jar schoolAdministration.jar
CMD ["java", "-jar", "schoolAdministration.jar"]