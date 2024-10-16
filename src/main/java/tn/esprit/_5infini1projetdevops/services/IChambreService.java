package tn.esprit._5infini1projetdevops.services;



import tn.esprit._5infini1projetdevops.Entity.Chambre;

import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    public void deleteChambre(Long idChambre);
    public Chambre updateChambre(Chambre chambre);
    public List<Chambre> getAllchambres();
    public Chambre getchambre(Long idChambre);


}