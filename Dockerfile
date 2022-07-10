FROM maven:3.8.2-jdk-11
WORKDIR /kafka-docker-spring_boot-base
#ARG JAR_FILE
#COPY ${JAR_FILE} kafka-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/COPY ${JAR_FILE} kafka-0.0.1-SNAPSHOT.jar"]
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run