package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Chambre;
import tn.esprit._5infini1projetdevops.Repository.ChambreRepository;


import java.util.List;
@AllArgsConstructor
@Service
public class ChambreServiceImpl implements IChambreService{


    private ChambreRepository chambreRepository;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);

    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllchambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre getchambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }
}
