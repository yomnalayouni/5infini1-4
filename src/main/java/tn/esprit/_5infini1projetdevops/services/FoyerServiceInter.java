package tn.esprit._5infini1projetdevops.services;


import tn.esprit._5infini1projetdevops.entity.Foyer;
import tn.esprit._5infini1projetdevops.entity.University;

import java.util.List;

public interface FoyerServiceInter {
    Foyer addOrUpdate(Foyer f);

    List<Foyer> findAll();

    Foyer findById(long id);

    void deleteById(long id);

    void delete(Foyer f);

    University affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    University desaffecterFoyerAUniversite(long idUniversite);

    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite); // Universite: Parent / Foyer:Child
    Foyer ajoutFoyerEtBlocs(Foyer foyer);

}
