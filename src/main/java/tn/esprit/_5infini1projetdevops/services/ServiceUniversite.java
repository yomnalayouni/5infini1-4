package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service

public class ServiceUniversite implements  IServiceUniversite{




        private UniversiteRepository universiteRepository;
        private FoyerRepository foyerRepository ;
        @Override
        public Universite addUniversite(Universite universite) {
            return universiteRepository.save(universite);
        }



        @Override
        public void deleteUniversite(Long idUniversite) {
            universiteRepository.deleteById(idUniversite);

        }

        @Override
        public Universite updateUniversite(Universite universite) {
            return universiteRepository.save(universite);
        }

        @Override
        public List<Universite> getAlluniversites() {
            return universiteRepository.findAll();
        }

    @Override
    public Universite getuniversite(Long idUniversite) {
        Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
        if (optionalUniversite.isPresent()) {
            return optionalUniversite.get();
        } else {
            throw new NoSuchElementException("No found with id: " + idUniversite);
        }
    }


    public void assignFoyerToUniversite(Long idUniversite, Long idFoyer) {
        Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
        if (!optionalUniversite.isPresent()) {
            throw new NoSuchElementException("No Universite found with id: " + idUniversite);
        }

        Optional<Foyer> optionalFoyer = foyerRepository.findById(idFoyer);
        if (!optionalFoyer.isPresent()) {
            throw new NoSuchElementException("No Foyer found with id: " + idFoyer);
        }

        Universite universite = optionalUniversite.get();
        Foyer foyer = optionalFoyer.get();

        // Set the Foyer in the Universite
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
    }

    public void unassignFoyerToUniversite(Long idUniversite) {
        Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);

        if (!optionalUniversite.isPresent()) {
            throw new NoSuchElementException("No Universite found with id: " + idUniversite);
        }

        Universite universite = optionalUniversite.get();

        // Set the Foyer to null
        universite.setFoyer(null);
        universiteRepository.save(universite);
    }



}
