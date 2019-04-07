FROM openjdk:8-alpine

COPY . /home/application
WORKDIR /home/application

RUN ./gradlew clean build
RUN mv ./build/libs/*.jar app.jar

#Variables
ENV TZ 'Europe/Madrid'

EXPOSE 8080 

CMD java -Xms400m -Xmx600m -jar ./app.jar

