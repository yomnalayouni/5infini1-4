# Utiliser une image OpenJDK 17 légère
FROM openjdk:17-jdk-alpine
<<<<<<< HEAD
LABEL authors="mortadha"
=======
LABEL authors="zina ghribi"
>>>>>>> de3295fc1421df8f2600926fa4d63316d6b5dac5
# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR depuis le dossier target
COPY target/*.jar app.jar

<<<<<<< HEAD

=======
>>>>>>> de3295fc1421df8f2600926fa4d63316d6b5dac5
EXPOSE 8089

# Exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]