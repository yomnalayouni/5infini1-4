package tn.esprit._5infini1projetdevops.services;

import tn.esprit._5infini1projetdevops.Entity.Reservation;
<<<<<<< HEAD
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Reservation;
=======

>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation addOrUpdate(Reservation r);
    List<Reservation> findAll();
    Reservation findById(String id);
    void deleteById(String id);
    void delete(Reservation r);
<<<<<<< HEAD
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Long numChambre, long cin) ;
    long  getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee ) ;
    String annulerReservation (long cinEtudiant) ;

    void affectReservationAChambre(String idRes,long idChambre);
=======
   // Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Long numChambre, long cin) ;
    //long  getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee ) ;
    //String annulerReservation (long cinEtudiant) ;

   // void affectReservationAChambre(String idRes,long idChambre);
>>>>>>> 9d3bef7087e220897522bd8fafe53b3ceac046e5
    void annulerReservations();




}