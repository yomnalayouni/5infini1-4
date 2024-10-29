package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Chambre;
import tn.esprit._5infini1projetdevops.Repository.ChambreRepository;


import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
import java.util.Optional;

=======
>>>>>>> university
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
<<<<<<< HEAD
        Optional<Chambre> optionalChambre = chambreRepository.findById(idChambre);
        if (optionalChambre.isPresent()) {
            return optionalChambre.get();
        } else {
            throw new NoSuchElementException("Chambre with ID " + idChambre + " not found.");
        }
    }

=======
        return chambreRepository.findById(idChambre).get();
    }
>>>>>>> university
}
