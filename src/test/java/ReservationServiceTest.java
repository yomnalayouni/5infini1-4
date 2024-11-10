import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit._5infini1projetdevops.Application;
import tn.esprit._5infini1projetdevops.Entity.Reservation;
import tn.esprit._5infini1projetdevops.Repository.ReservationRepository;
import tn.esprit._5infini1projetdevops.services.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
@ContextConfiguration(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    private Reservation reservation;

    @BeforeEach
    public void setUp() {
        // Initialize the Reservation object with example data
        reservation = new Reservation();
        reservation.setIdReservation("R-2024-001"); // Example ID as String
    }

    @Test
    void testAddOrUpdate() {
        // Arrange
        when(reservationRepository.save(reservation)).thenReturn(reservation);

        // Act
        Reservation result = reservationService.addOrUpdate(reservation);

        // Assert
        assertNotNull(result);
        assertEquals(reservation.getIdReservation(), result.getIdReservation());
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);
        when(reservationRepository.findAll()).thenReturn(reservations);

        // Act
        List<Reservation> result = reservationService.findAll();

        // Assert
        assertEquals(reservations, result);
        assertFalse(result.isEmpty());
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        String id = "R-2024-001";
        when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));

        // Act
        Reservation result = reservationService.findById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getIdReservation());
        verify(reservationRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_NotFound() {
        // Arrange
        String id = "R-2024-999"; // ID that does not exist
        when(reservationRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Reservation result = reservationService.findById(id);

        // Assert
        assertNull(result); // Expecting null since the reservation doesn't exist
        verify(reservationRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteById() {
        // Arrange
        String id = "R-2024-001";
        doNothing().when(reservationRepository).deleteById(id);

        // Act
        reservationService.deleteById(id);

        // Assert
        verify(reservationRepository, times(1)).deleteById(id);
    }

    @Test
    void testDelete() {
        // Arrange
        doNothing().when(reservationRepository).delete(reservation);

        // Act
        reservationService.delete(reservation);

        // Assert
        verify(reservationRepository, times(1)).delete(reservation);
    }

    // Optional: Test for annulerReservations (if implemented)
    @Test
    void testAnnulerReservations() {
        // Add logic to test the annulerReservations method here.
    }
    @Test
    void contextLoads() {
        assertNotNull(reservationService, "reservationService should be autowired and not null");
    }
}
