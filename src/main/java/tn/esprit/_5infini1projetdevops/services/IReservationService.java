package tn.esprit._5infini1projetdevops.services;

import tn.esprit._5infini1projetdevops.Entity.Reservation;

<<<<<<< HEAD
=======

import java.time.LocalDate;
>>>>>>> university
import java.util.List;

public interface IReservationService {
    Reservation addOrUpdate(Reservation r);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    void delete(Reservation r);
<<<<<<< HEAD
    void annulerReservations();
}
=======
   // Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Long numChambre, long cin) ;
    //long  getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee ) ;
    //String annulerReservation (long cinEtudiant) ;

   // void affectReservationAChambre(String idRes,long idChambre);
    void annulerReservations();




}
>>>>>>> university
