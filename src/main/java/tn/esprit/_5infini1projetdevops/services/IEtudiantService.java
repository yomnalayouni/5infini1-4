package tn.esprit._5infini1projetdevops.services;

import tn.esprit._5infini1projetdevops.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addOrUpdate(Etudiant e);
    List<Etudiant> findAll();
    Etudiant findById(long id);
    void deleteById(long id);
    void delete(Etudiant e);
}