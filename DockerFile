FROM openjdk:17
COPY ".target/quiz_crud_tres-1.jar" "app.jar"
EXPOSE 8130
ENTRYPOINT [ "java", "-jar", "app.jar" ]