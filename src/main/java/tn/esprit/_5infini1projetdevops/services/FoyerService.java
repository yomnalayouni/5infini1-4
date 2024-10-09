package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Bloc;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Entity.University;
import tn.esprit._5infini1projetdevops.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService {
    FoyerRepository repo;
    UniversiteRepository universiteRepository;
    BlocRepository blocRepository;

    @Override
    public Foyer addOrUpdate(Foyer f) {
        return repo.save(f);
    }

    @Override
    public List<Foyer> findAll() {
        return repo.findAll();
    }

    @Override
    public Foyer findById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Foyer f) {
        repo.delete(f);
    }

    @Override
    public University affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f = findById(idFoyer); // Child
        University u = universiteRepository.findByNomUniversite(nomUniversite); // Parent
        // On affecte le child au parent
        u.setFoyer(f);
        return universiteRepository.save(u);
    }

    @Override
    public University desaffecterFoyerAUniversite(long idUniversite) {
        University u = universiteRepository.findById(idUniversite).get(); // Parent
        u.setFoyer(null);
        return universiteRepository.save(u);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        // Récuperer la liste des blocs avant de faire l'ajout
        List<Bloc> blocs = foyer.getBlocs();
        // Foyer est le child et universite est parent
        Foyer f = repo.save(foyer);
        University u = universiteRepository.findById(idUniversite).get();
        // Foyer est le child et bloc est le parent
        //On affecte le child au parent
        for (Bloc bloc : blocs) {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }
        u.setFoyer(f);
        return universiteRepository.save(u).getFoyer();
    }

    @Override
    public Foyer ajoutFoyerEtBlocs(Foyer foyer) {
        //Foyer child / Bloc parent
        //Objet foyer = attribut objet foyer + les blocs associés
//        Foyer f = repo.save(foyer);
//        for (Bloc b : foyer.getBlocs()) {
//            b.setFoyer(f);
//            blocRepository.save(b);
//        }
//        return f;
        //-----------------------------------------
        List<Bloc> blocs = foyer.getBlocs();
        foyer = repo.save(foyer);
        for (Bloc b : blocs) {
            b.setFoyer(foyer);
            blocRepository.save(b);
        }
        return foyer;
    }


}
