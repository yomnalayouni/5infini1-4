package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Repository.ChambreRepository;
import tn.esprit._5infini1projetdevops.Repository.ReservationRepository;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
=======
import tn.esprit._5infini1projetdevops.Entity.Chambre;
import tn.esprit._5infini1projetdevops.Entity.Etudiant;
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.Repository.ChambreRepository;
import tn.esprit._5infini1projetdevops.Repository.EtudiantRepository;
import tn.esprit._5infini1projetdevops.Repository.ReservationRepository;




import java.time.LocalDate;
import java.util.List;
>>>>>>> university

@Service
@AllArgsConstructor
@Slf4j
public class ReservationService implements IReservationService {
<<<<<<< HEAD
    private final ReservationRepository repo;
    private final ChambreRepository chambreRepository;
    private final UniversiteRepository universiteRepository;
=======
    ReservationRepository repo;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
>>>>>>> university

    @Override
    public Reservation addOrUpdate(Reservation r) {
        return repo.save(r);
    }

    @Override
    public List<Reservation> findAll() {
        return repo.findAll();
    }

    @Override
    public Reservation findById(String id) {
<<<<<<< HEAD
        return repo.findById(id).orElse(null);
=======
        return repo.findById(id).get();
>>>>>>> university
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Reservation r) {
        repo.delete(r);
    }

<<<<<<< HEAD
    @Override
    public void annulerReservations() {
        LocalDate dateDebutAU;
        LocalDate dateFinAU;
        int year = LocalDate.now().getYear() % 100;

=======
   /* @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Long numChambre, long cin) {
        // Pour l’ajout de Réservation, l’id est un String et c’est la concaténation de "numeroChambre",
        // "nomBloc" et "cin". Aussi, l’ajout ne se fait que si la capacite maximale de la chambre est encore non atteinte.

        // Début "récuperer l'année universitaire actuelle"
        LocalDate dateDebutAU;
        LocalDate dateFinAU;
        int numReservation;
        int year = LocalDate.now().getYear() % 100;
>>>>>>> university
        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }
<<<<<<< HEAD

        for (Reservation reservation : repo.findByEstValideAndAnneeUniversitaireBetween(true, dateDebutAU, dateFinAU)) {
            reservation.setEstValide(false);
            repo.save(reservation);
            log.info("La reservation " + reservation.getIdReservation() + " est annulée automatiquement");
        }
    }

    
    public Universite getuniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new NoSuchElementException("Université with ID " + idUniversite + " not found"));
    }
   
   public void assignFoyerToUniversite(Long idUniversite, Foyer foyer) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new NoSuchElementException("Université not found"));
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
    }
   
   public void unassignFoyerToUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new NoSuchElementException("Université not found"));
        universite.setFoyer(null);
        universiteRepository.save(universite);
    }
=======
        // Fin "récuperer l'année universitaire actuelle"
        Reservation res = new Reservation();
        Chambre c = chambreRepository.findByNumeroChambre(numChambre);
        Etudiant e = etudiantRepository.findByCin(cin);
        boolean ajout = false;
        int numRes = chambreRepository.countReservationsByIdChambreAndReservationsAnneeUniversitaireBetween(c.getIdChambre(), dateDebutAU, dateFinAU);
        //int numRes = chambreRepository.listerReservationPourUneChambre(c.getIdChambre(), dateDebutAU, dateFinAU);
        System.err.println(numRes);
        switch (c.getTypeC()) {
            case SIMPLE:
                if (numRes < 1) {
                    ajout = true;
                } else {
                    log.info("Chambre simple remplie !");
                }
                break;
            case DOUBLE:
                if (numRes < 2) {
                    ajout = true;
                } else {
                    log.info("Chambre double remplie !");
                }
                break;
            case TRIPLE:
                if (numRes < 3) {
                    ajout = true;
                } else {
                    log.info("Chambre triple remplie !");
                }
                break;
        }
        if (ajout) {
            res.setEstValide(false);
            res.setAnneeUniversitaire(LocalDate.now());
            // AU-BLOC-NumChambre-CIN --> Exemple: 2023/2024-Bloc A-1-123456789
            //res.setIdReservation(c.getNumeroChambre() + "-" + c.getBloc().getNomBloc() + "-" + e.getCin());
            res.setIdReservation(dateDebutAU.getYear() + "/" + dateFinAU.getYear() + "-" + c.getBloc().getNomBloc() + "-" + c.getNumeroChambre() + "-" + e.getCin());
            res.getEtudiants().add(e);
            res.setEstValide(true);
            res = repo.save(res);
            c.getReservations().add(res);
            chambreRepository.save(c);
        }
        return res;
    }
*/
   /* @Override
    public long getReservationParAnneeUniversitaire(LocalDate debutAnnee, LocalDate finAnnee) {
        return repo.countByAnneeUniversitaireBetween(debutAnnee, finAnnee);
    }
*/
  /*  @Override
    public String annulerReservation(long cinEtudiant) {
        Reservation r = repo.findByEtudiantsCinAndEstValide(cinEtudiant, true);
        Chambre c = chambreRepository.findByReservationsIdReservation(r.getIdReservation());
        c.getReservations().remove(r);
        chambreRepository.save(c);
        repo.delete(r);
        return "La réservation " + r.getIdReservation() + " est annulée avec succés";
    }
*/
   /* @Override
    public void affectReservationAChambre(String idRes, long idChambre) {
        Reservation r = repo.findById(idRes).get();
        Chambre c = chambreRepository.findById(idChambre).get();
        // Parent: Chambre , Child: Reservation
        // On affecte le child au parent
        c.getReservations().add(r);
        chambreRepository.save(c);
    }
*/
    @Override
    public void annulerReservations() {
        // Début "récuperer l'année universitaire actuelle"
        LocalDate dateDebutAU;
        LocalDate dateFinAU;
        int numReservation;
        int year = LocalDate.now().getYear() % 100;
        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }
        // Fin "récuperer l'année universitaire actuelle"
        for (Reservation reservation : repo.findByEstValideAndAnneeUniversitaireBetween(true, dateDebutAU, dateFinAU)) {
            reservation.setEstValide(false);
            repo.save(reservation);
            log.info("La reservation "+ reservation.getIdReservation()+" est annulée automatiquement");
        }
    }

>>>>>>> university
}
