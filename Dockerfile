FROM openjdk:17
ADD build/libs/Test2-1.0-SNAPSHOT.jar app1.jar
ENTRYPOINT [ "java", "-jar","app1.jar" ]