package tn.esprit._5infini1projetdevops.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Chambre;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.services.ChambreServiceImpl;
import tn.esprit._5infini1projetdevops.services.ServiceUniversite;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestControllers {

    public ServiceUniversite universiteService;
    public ChambreServiceImpl chambreService ;
    @GetMapping("/show-universite")
    public List<Universite> getAlluniversites() {

        List<Universite> listUniversites = universiteService.getAlluniversites();
        return listUniversites;
    }

    @GetMapping("/show-chambre")
    public List<Chambre> getAllchambres() {
        List<Chambre> listChambres = chambreService.getAllchambres();
        return listChambres;
    }

    @GetMapping("/show-chambreid/{id}")
    public List<Chambre> getChambre(@PathVariable ("id") Long idChambre)
    {
        return (List<Chambre>) chambreService.getchambre(idChambre);
    }


    @PostMapping(path = "/add-chambre")
    public Chambre addChambre (@RequestBody Chambre chambre)
    {
        return chambreService.addChambre(chambre);
    }

    @DeleteMapping(path = "/delete-chambre/{id}")
    public void deleteChambre (@PathVariable ("id") Long idChambre)
    {
        chambreService.deleteChambre(idChambre);
    }

    @PutMapping(path = "/update-chambre")
    public Chambre updateChambre( @RequestBody Chambre c)
    {

        Chambre chambre = chambreService.updateChambre(c);
        return chambre ;
    }


}
