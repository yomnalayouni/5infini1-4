package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.List;
@AllArgsConstructor
@Service

public class ServiceUniversite implements  IServiceUniversite{




        private UniversiteRepository universiteRepository;
<<<<<<< HEAD
       // private FoyerRepository foyerRepository ;
=======
        private FoyerRepository foyerRepository ;
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
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
            return universiteRepository.findById(idUniversite).get();
        }

<<<<<<< HEAD
       /* public void assignFoyerToUniversite(Long idUniversite, Long idFoyer) {
=======
        public void assignFoyerToUniversite(Long idUniversite, Long idFoyer) {
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
            Universite universite = universiteRepository.findById(idUniversite).get();
            Foyer foyer = foyerRepository.findById(idFoyer).get();
// on set le fils dans le parent :
            universite.setFoyer(foyer);
            universiteRepository.save(universite);
<<<<<<< HEAD
        }*/
=======
        }
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
        public void unassignFoyerToUniversite(Long idUniversite) {
            Universite universite = universiteRepository.findById(idUniversite).get();
            //Foyer foyer = foyerRepository.findById(idFoyer).get();
// on set le fils dans le parent :
            universite.setFoyer(null);
            universiteRepository.save(universite);
        }


}
