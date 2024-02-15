FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /home
COPY . .
EXPOSE 8080
RUN mvn package
CMD ["java", "-jar","target/db-0.0.1-SNAPSHOT.war"]
