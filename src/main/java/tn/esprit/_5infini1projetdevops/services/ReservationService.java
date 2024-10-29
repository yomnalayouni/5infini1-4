package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Repository.ChambreRepository;
import tn.esprit._5infini1projetdevops.Repository.ReservationRepository;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationService implements IReservationService {
    private final ReservationRepository repo;
    private final ChambreRepository chambreRepository;
    private final UniversiteRepository universiteRepository;

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
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Reservation r) {
        repo.delete(r);
    }

    @Override
    public void annulerReservations() {
        LocalDate dateDebutAU;
        LocalDate dateFinAU;
        int year = LocalDate.now().getYear() % 100;

        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }

        for (Reservation reservation : repo.findByEstValideAndAnneeUniversitaireBetween(true, dateDebutAU, dateFinAU)) {
            reservation.setEstValide(false);
            repo.save(reservation);
            log.info("La reservation " + reservation.getIdReservation() + " est annulée automatiquement");
        }
    }

    @Override
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
}
