package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======
import tn.esprit._5infini1projetdevops.Entity.Bloc;
>>>>>>> university
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.Repository.BlocRepository;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
import    tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;

import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
import java.util.Optional;
=======
>>>>>>> university

@Service
@AllArgsConstructor
public class FoyerService implements FoyerServiceInter {
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
<<<<<<< HEAD
    @Override
    public Foyer findById(long id) {
        Optional<Foyer> optionalFoyer = repo.findById(id);
        if (optionalFoyer.isPresent()) {
            return optionalFoyer.get();
        } else {
            throw new NoSuchElementException("Foyer with ID " + id + " not found.");
        }
=======

        @Override
        public Foyer findById ( long id){
            return repo.findById(id).get();
>>>>>>>university
        }

        @Override
        public void deleteById ( long id){
            repo.deleteById(id);
        }

        @Override
        public void delete (Foyer f){
            repo.delete(f);
        }

        @Override
        public Universite affecterFoyerAUniversite ( long idFoyer, String nomUniversite){
            return null;
        }


        @Override
        public Universite desaffecterFoyerAUniversite ( long idUniversite){
            Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
            if (optionalUniversite.isPresent()) {
                Universite u = optionalUniversite.get();
                u.setFoyer(null);
                return universiteRepository.save(u);
            } else {
                throw new NoSuchElementException("Universite with ID " + idUniversite + " not found.");
            }
        }


        @Override
        public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer,long idUniversite){
            return null;
        }

        @Override
        public Foyer ajoutFoyerEtBlocs (Foyer foyer){
            return null;
        }


    }}
