FROM openjdk:8u111-jre

RUN mkdir /app

WORKDIR /app

ADD build/libs/todo.jar /app/todo.jar

CMD java -jar /app/todo.jar