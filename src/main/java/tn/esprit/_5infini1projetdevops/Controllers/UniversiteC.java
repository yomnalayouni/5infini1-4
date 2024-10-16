package tn.esprit._5infini1projetdevops.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.services.ServiceUniversite;

import java.util.List;

public class UniversiteC {
    public ServiceUniversite universiteService;

    @GetMapping("/show-universite")
    public List<Universite> getAlluniversites() {
        List<Universite> listUniversites = universiteService.getAlluniversites();
        return listUniversites;
    }

    @GetMapping("/show-universiteid/{id}")
    public List<UniversiteC> getUniversite(@PathVariable("id") Long idUniversite)
    {
        return (List<UniversiteC>) universiteService.getuniversite(idUniversite);
    }

    @PostMapping(path = "/add-universite")
    public Universite addUniversite (@RequestBody Universite universite)
    {
        return universiteService.addUniversite(universite);
    }

    @DeleteMapping(path = "/delete-universite/{id}")
    public void deleteUniversite (@PathVariable ("id") Long idUniversite)
    {
        universiteService.deleteUniversite(idUniversite);
    }

    @PutMapping(path = "/update-universite")
    public Universite updateRUniversite(@RequestBody Universite c)
    {

        Universite universite = universiteService.updateUniversite(c);
        return universite ;
    }

    @PutMapping("/affecter-universite-a-foyer/{universite-id}/{foyer-id}")
    public void  assignFoyerToUniversite(@PathVariable("universite-id") Long idUniversite,
                                         @PathVariable("foyer-id") Long idFoyer) {
        universiteService.assignFoyerToUniversite(idUniversite,idFoyer);
    }
    @PutMapping("/deaffecter-universite-a-foyer/{universite-id}")
    public void  enassignFoyerToUniversite(@PathVariable("universite-id") Long idUniversite) {
        universiteService.unassignFoyerToUniversite(idUniversite);
    }}