package tn.esprit._5infini1projetdevops.Services;

import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.List;

public interface IServiceUniversite {

    public Universite addUniversite(Universite universite);


    void deleteUniversite(Long idUniversite);

    public Universite updateUniversite(Universite universite);
    public List<Universite> getAlluniversites();
    public Universite getuniversite (Long idUniversite);
   public void  assignFoyerToUniversite(Long idUniversite, Long idFoyer);
    public void unassignFoyerToUniversite(Long idUniversite);

}
