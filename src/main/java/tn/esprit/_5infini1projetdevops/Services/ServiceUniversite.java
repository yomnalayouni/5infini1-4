package tn.esprit._5infini1projetdevops.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.List;
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
            return universiteRepository.findById(idUniversite).get();
        }

        public void assignFoyerToUniversite(Long idUniversite, Long idFoyer) {
            Universite universite = universiteRepository.findById(idUniversite).get();
            Foyer foyer = foyerRepository.findById(idFoyer).get();
// on set le fils dans le parent :
            universite.setFoyer(foyer);
            universiteRepository.save(universite);
        }
        public void unassignFoyerToUniversite(Long idUniversite) {
            Universite universite = universiteRepository.findById(idUniversite).get();
            //Foyer foyer = foyerRepository.findById(idFoyer).get();
// on set le fils dans le parent :
            universite.setFoyer(null);
            universiteRepository.save(universite);
        }


}
