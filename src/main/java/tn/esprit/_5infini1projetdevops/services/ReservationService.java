package tn.esprit._5infini1projetdevops.services.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.Repository.ReservationRepository;
import tn.esprit._5infini1projetdevops.services.ReservationService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest { // Removed 'public' modifier

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private Reservation reservation;

    @BeforeEach
    void setUp() {
        reservation = new Reservation();
        reservation.setIdReservation("1");
        reservation.setEstValide(true);
        // Set other properties as needed
    }

    @Test
    void testAddOrUpdate() {
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        Reservation savedReservation = reservationService.addOrUpdate(reservation);

        verify(reservationRepository, times(1)).save(reservation);
        assertEquals(reservation, savedReservation);
    }

    @Test
    void testFindAll() {
        List<Reservation> reservations = Arrays.asList(reservation);
        when(reservationRepository.findAll()).thenReturn(reservations);

        List<Reservation> foundReservations = reservationService.findAll();

        verify(reservationRepository, times(1)).findAll();
        assertEquals(1, foundReservations.size());
        assertEquals(reservation, foundReservations.get(0));
    }

    @Test
    void testFindById() {
        when(reservationRepository.findById("1")).thenReturn(Optional.of(reservation));

        Reservation foundReservation = reservationService.findById("1");

        verify(reservationRepository, times(1)).findById("1");
        assertEquals(reservation, foundReservation);
    }

    @Test
    void testDeleteById() {
        reservationService.deleteById("1");

        verify(reservationRepository, times(1)).deleteById("1");
    }

    @Test
    void testAnnulerReservations() {
        LocalDate dateDebutAU = LocalDate.of(2022, 9, 15);
        LocalDate dateFinAU = LocalDate.of(2023, 6, 30);
        reservation.setAnneeUniversitaire(2022); // Assuming this method exists
        
        when(reservationRepository.findByEstValideAndAnneeUniversitaireBetween(true, dateDebutAU, dateFinAU))
                .thenReturn(Arrays.asList(reservation));

        reservationService.annulerReservations();

        verify(reservationRepository, times(1)).findByEstValideAndAnneeUniversitaireBetween(true, dateDebutAU, dateFinAU);
        verify(reservationRepository, times(1)).save(reservation);
        assertEquals(false, reservation.isEstValide());
    }
}
