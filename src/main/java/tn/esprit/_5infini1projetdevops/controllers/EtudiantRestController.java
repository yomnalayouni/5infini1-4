package tn.esprit._5infini1projetdevops.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Chambre;
import tn.esprit._5infini1projetdevops.Entity.Etudiant;
import tn.esprit._5infini1projetdevops.services.Chambre.IChambreService;
import tn.esprit._5infini1projetdevops.services.Etudiant.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("etudiant")
@AllArgsConstructor
public class EtudiantRestController {
    IEtudiantService service;

    @PostMapping("addOrUpdate")
    Etudiant addOrUpdate(@RequestBody Etudiant e) {
        return service.addOrUpdate(e);
    }

    @GetMapping("findAll")
    List<Etudiant> findAll() {
        return service.findAll();
    }

    @GetMapping("findById")
    Etudiant findById(@RequestParam long id) {
        return service.findById(id);
    }

    @DeleteMapping("delete")
    void delete(@RequestBody Etudiant e) {
        service.delete(e);
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam long id) {
        service.deleteById(id);
    }
}