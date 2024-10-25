package tn.esprit._5infini1projetdevops.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.services.IReservationService;

import java.time.LocalDate;
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
    @PostMapping("ajouterReservationEtAssignerAChambreEtAEtudiant")
=======
  /*  @PostMapping("ajouterReservationEtAssignerAChambreEtAEtudiant")
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(@RequestParam Long numChambre, @RequestParam long cin) {
        return service.ajouterReservationEtAssignerAChambreEtAEtudiant(numChambre, cin);
    }

    @GetMapping("getReservationParAnneeUniversitaire")
    long getReservationParAnneeUniversitaire(@RequestParam LocalDate debutAnnee, @RequestParam LocalDate finAnnee) {
        return service.getReservationParAnneeUniversitaire(debutAnnee, finAnnee);
    }
<<<<<<< HEAD

    @DeleteMapping("annulerReservation")
    String annulerReservation(@RequestParam long cinEtudiant) {
        return service.annulerReservation(cinEtudiant);
    }
=======
*/
  /*  @DeleteMapping("annulerReservation")
    String annulerReservation(@RequestParam long cinEtudiant) {
        return service.annulerReservation(cinEtudiant);
    }*/
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
}
