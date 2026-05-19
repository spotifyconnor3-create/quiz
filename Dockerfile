FROM eclipse-temurin:21-jdk
COPY ".target/quiz_crud_tres-1.jar" "app.jar"
EXPOSE 8130
ENTRYPOINT [ "java", "-jar", "app.jar" ]