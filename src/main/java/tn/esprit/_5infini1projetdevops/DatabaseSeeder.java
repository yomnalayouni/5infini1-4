package tn.esprit._5infini1projetdevops;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.*;
import tn.esprit._5infini1projetdevops.Repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class DatabaseSeeder {

    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;

    @PostConstruct
    public void seedDatabase() {
        // Vérifier si la base de données est vide
        if (foyerRepository.count() == 0 && etudiantRepository.count() == 0) {
            System.out.println("La base de données est vide. Exécution du seeding...");

            // Créez les foyers
            Foyer foyerA = new Foyer(null, "Foyer A", 100, null, new ArrayList<>());
            Foyer foyerB = new Foyer(null, "Foyer B", 150, null, new ArrayList<>());

            // Associez les universités aux foyers
            Universite universiteSciences = new Universite(null, "Université des Sciences", "200 Avenue des Sciences", foyerA);
            Universite universiteLettres = new Universite(null, "Université des Lettres", "300 Boulevard des Lettres", foyerB);

            universiteRepository.saveAll(Arrays.asList(universiteSciences, universiteLettres));

            // Créez les blocs et associez-les aux foyers
            Bloc bloc1FoyerA = new Bloc(null, "Bloc 1", 50, foyerA, new ArrayList<>());
            Bloc bloc2FoyerA = new Bloc(null, "Bloc 2", 50, foyerA, new ArrayList<>());
            Bloc bloc1FoyerB = new Bloc(null, "Bloc 1", 75, foyerB, new ArrayList<>());
            Bloc bloc2FoyerB = new Bloc(null, "Bloc 2", 75, foyerB, new ArrayList<>());

            // Sauvegarder les blocs
            blocRepository.saveAll(Arrays.asList(bloc1FoyerA, bloc2FoyerA, bloc1FoyerB, bloc2FoyerB));

            // Créez les étudiants
            List<Etudiant> etudiants = Arrays.asList(
                    new Etudiant(null, "Doe", "John", 123456789L, "École d'Ingénieurs", LocalDate.parse("1998-04-01"), new ArrayList<>()),
                    new Etudiant(null, "Smith", "Anna", 987654321L, "Faculté des Arts", LocalDate.parse("2000-08-15"), new ArrayList<>()),
                    new Etudiant(null, "Roe", "Jane", 159753486L, "École de Commerce", LocalDate.parse("1999-11-23"), new ArrayList<>()),
                    new Etudiant(null, "Lee", "Chris", 357951846L, "École de Droit", LocalDate.parse("1997-07-30"), new ArrayList<>())
            );
            etudiantRepository.saveAll(etudiants);

            // Créez les chambres et les associez aux blocs
            bloc1FoyerA.addChambre(new Chambre(null, 101L, TypeChambre.SIMPLE, bloc1FoyerA, new ArrayList<>()));
            bloc1FoyerA.addChambre(new Chambre(null, 102L, TypeChambre.DOUBLE, bloc1FoyerA, new ArrayList<>()));
            bloc2FoyerA.addChambre(new Chambre(null, 201L, TypeChambre.SIMPLE, bloc2FoyerA, new ArrayList<>()));
            bloc2FoyerA.addChambre(new Chambre(null, 202L, TypeChambre.TRIPLE, bloc2FoyerA, new ArrayList<>()));
            bloc1FoyerB.addChambre(new Chambre(null, 301L, TypeChambre.DOUBLE, bloc1FoyerB, new ArrayList<>()));
            bloc1FoyerB.addChambre(new Chambre(null, 302L, TypeChambre.TRIPLE, bloc1FoyerB, new ArrayList<>()));
            bloc2FoyerB.addChambre(new Chambre(null, 401L, TypeChambre.SIMPLE, bloc2FoyerB, new ArrayList<>()));
            bloc2FoyerB.addChambre(new Chambre(null, 402L, TypeChambre.DOUBLE, bloc2FoyerB, new ArrayList<>()));

            // Sauvegarder les blocs avec les chambres associées
            blocRepository.saveAll(Arrays.asList(bloc1FoyerA, bloc2FoyerA, bloc1FoyerB, bloc2FoyerB));
        } else {
            System.out.println("La base de données contient déjà des données. Le seeding est ignoré.");
        }
    }

}
