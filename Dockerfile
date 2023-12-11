# Используйте официальный образ OpenJDK для Java
FROM openjdk:17-jdk-slim
MAINTAINER Karen Petrosian

# Копируем JAR-файл вашего приложения в контейнер
COPY target/casino-jwt-service-0.0.1-SNAPSHOT.jar /app/app.jar

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Открываем порт 8080 для внешних подключений
EXPOSE 8080

# Запускаем ваше приложение при старте контейнера
ENTRYPOINT ["java", "-jar", "app.jar"]
