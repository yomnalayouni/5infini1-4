# Utiliser une image OpenJDK 17 légère
FROM openjdk:17-jdk-alpine
LABEL authors="mortadha"
# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR depuis le dossier target
COPY target/*.jar app.jar


EXPOSE 8089

# Exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]