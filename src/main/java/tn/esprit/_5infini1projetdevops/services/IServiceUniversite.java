package tn.esprit._5infini1projetdevops.services;

import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.List;

public interface IServiceUniversite {

    public Universite addUniversite(Universite universite);


    void deleteUniversite(Long idUniversite);

    public Universite updateUniversite(Universite universite);
    public List<Universite> getAlluniversites();
    public Universite getuniversite (Long idUniversite);
<<<<<<< HEAD
   // public void  assignFoyerToUniversite(Long idUniversite, Long idFoyer);
=======
    public void  assignFoyerToUniversite(Long idUniversite, Long idFoyer);
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
    public void unassignFoyerToUniversite(Long idUniversite);

}
