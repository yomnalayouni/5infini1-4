package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Etudiant;
import tn.esprit._5infini1projetdevops.Repository.EtudiantRepository;

import java.util.List;

@Service


public class EtudiantService implements IEtudiantService {

    private final EtudiantRepository repo;

    @Autowired
    public EtudiantService(EtudiantRepository repo) {
        this.repo = repo;
    }


    @Override
    public Etudiant addOrUpdate(Etudiant e) {
        return repo.save(e);
    }

    @Override
    public List<Etudiant> findAll() {
        return repo.findAll();
    }

   @Override
   public Etudiant findById(long id) {
    return repo.findById(id).orElse(null);
    }



    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Etudiant e) {
        repo.delete(e);
    }
}
