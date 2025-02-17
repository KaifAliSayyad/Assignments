FROM openjdk:17


COPY ./*  /usr/app/

WORKDIR /usr/app

ENV CLASSPATH="./postgresql-42.7.3.jar:./EmployeeManagementApp-0.0.1-SNAPSHOT.jar:$CLASSPATH"

RUN javac -d . *.java

CMD [ "java", "EmployeeManagementApp" ]