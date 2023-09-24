FROM openjdk:17-jdk
COPY target/*.jar app.jar
ENV DATABASE_URL "jdbc:postgresql://localhost:5432/Diagnostico"
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
