package tn.esprit._5infini1projetdevops.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Etudiant;
import tn.esprit._5infini1projetdevops.services.EtudiantService;



<<<<<<< HEAD
=======



>>>>>>> de3295fc1421df8f2600926fa4d63316d6b5dac5
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestControllor {


    public EtudiantService etudiantService ;

    @GetMapping("/show-etudiant")
    public List<Etudiant> getAlletudiants() {
        List<Etudiant> listEtudiants = etudiantService.findAll();
        return listEtudiants;
    }

    @GetMapping("/show-etudiantid/{id}")
    public List<Etudiant> getEtudiant(@PathVariable("id") Long idEtudiant)
    {
        return (List<Etudiant>) etudiantService.findById(idEtudiant);
    }

    @PostMapping(path = "/add-etudiant")
    public Etudiant addEtudiant (@RequestBody Etudiant etudiant)
    {
        return etudiantService.addOrUpdate(etudiant);
    }

    @DeleteMapping(path = "/delete-etudiant/{id}")
    public void deleteEtudiant (@PathVariable ("id") Long idEtudiant)
    {
        etudiantService.deleteById(idEtudiant);
    }

    @PutMapping(path = "/update-etudiant")
    public Etudiant updateBloc(@RequestBody Etudiant e )
    {

        Etudiant etudiant = etudiantService.addOrUpdate(e);
        return etudiant ;
    }
}
