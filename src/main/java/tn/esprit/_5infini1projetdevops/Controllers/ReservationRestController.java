package tn.esprit._5infini1projetdevops.Controllers;

<<<<<<< HEAD
=======

>>>>>>> university
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.services.IReservationService;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> university
import java.util.List;

@RestController
@RequestMapping("reservation")
@AllArgsConstructor
public class ReservationRestController {
    IReservationService service;

    @PostMapping("addOrUpdate")
    Reservation addOrUpdate(@RequestBody Reservation r) {
        return service.addOrUpdate(r);
    }

    @GetMapping("findAll")
    List<Reservation> findAll() {
        return service.findAll();
    }

    @GetMapping("findById")
    Reservation findById(@RequestParam String id) {
        return service.findById(id);
    }

    @DeleteMapping("delete")
    void delete(@RequestBody Reservation r) {
        service.delete(r);
    }

    @DeleteMapping("deleteById")
    void deleteById(@RequestParam String id) {
        service.deleteById(id);
    }
<<<<<<< HEAD
=======

  /*  @PostMapping("ajouterReservationEtAssignerAChambreEtAEtudiant")
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(@RequestParam Long numChambre, @RequestParam long cin) {
        return service.ajouterReservationEtAssignerAChambreEtAEtudiant(numChambre, cin);
    }

    @GetMapping("getReservationParAnneeUniversitaire")
    long getReservationParAnneeUniversitaire(@RequestParam LocalDate debutAnnee, @RequestParam LocalDate finAnnee) {
        return service.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }
*/
  /*  @DeleteMapping("annulerReservation")
    String annulerReservation(@RequestParam long cinEtudiant) {
        return service.annulerReservation(cinEtudiant);
    }*/
>>>>>>> university
}
