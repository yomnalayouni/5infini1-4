package tn.esprit._5infini1projetdevops.services;


import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.List;

public interface FoyerServiceInter {
    Foyer addOrUpdate(Foyer f);

    List<Foyer> findAll();

    Foyer findById(long id);

    void deleteById(long id);

    void delete(Foyer f);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);

    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite); // Universite: Parent / Foyer:Child
    Foyer ajoutFoyerEtBlocs(Foyer foyer);

}
