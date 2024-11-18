import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit._5infini1projetdevops.Entity.Chambre;
import tn.esprit._5infini1projetdevops.Entity.TypeChambre;
import tn.esprit._5infini1projetdevops.Repository.ChambreRepository;
import tn.esprit._5infini1projetdevops.services.ChambreServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ChambreServiceTest {
    @Mock
    private ChambreRepository chambreRepository;

    @InjectMocks
    private ChambreServiceImpl chambreService;

    private Chambre chambre;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        chambre = new Chambre();
        chambre.setIdChambre(1L);
        chambre.setNumeroChambre(101L);
        chambre.setTypeC(TypeChambre.SIMPLE);
    }

    @Test
    void addChambre_ShouldReturnSavedChambre() {
        when(chambreRepository.save(chambre)).thenReturn(chambre);
        Chambre savedChambre = chambreService.addChambre(chambre);
        assertNotNull(savedChambre);
        assertEquals(1L, savedChambre.getIdChambre());
        verify(chambreRepository, times(1)).save(chambre);
    }

    @Test
    void deleteChambre_ShouldCallRepositoryDelete() {
        Long idChambre = 1L;
        doNothing().when(chambreRepository).deleteById(idChambre);
        chambreService.deleteChambre(idChambre);
        verify(chambreRepository, times(1)).deleteById(idChambre);
    }

    @Test
    void updateChambre_ShouldReturnUpdatedChambre() {
        when(chambreRepository.save(chambre)).thenReturn(chambre);
        Chambre updatedChambre = chambreService.updateChambre(chambre);
        assertNotNull(updatedChambre);
        assertEquals(1L, updatedChambre.getIdChambre());
        verify(chambreRepository, times(1)).save(chambre);
    }

    @Test
    void getAllchambres_ShouldReturnListOfChambres() {
        Chambre chambre2 = new Chambre();
        chambre2.setIdChambre(2L);
        chambre2.setNumeroChambre(102L);
        chambre2.setTypeC(TypeChambre.DOUBLE);
        when(chambreRepository.findAll()).thenReturn(Arrays.asList(chambre, chambre2));
        List<Chambre> chambres = chambreService.getAllchambres();
        assertEquals(2, chambres.size());
        verify(chambreRepository, times(1)).findAll();
    }

    @Test
    void getchambre_ShouldReturnChambre_WhenChambreExists() {
        Long idChambre = 1L;
        when(chambreRepository.findById(idChambre)).thenReturn(Optional.of(chambre));
        Chambre foundChambre = chambreService.getchambre(idChambre);
        assertNotNull(foundChambre);
        assertEquals(idChambre, foundChambre.getIdChambre());
        verify(chambreRepository, times(1)).findById(idChambre);
    }

    @Test
    void getchambre_ShouldThrowException_WhenChambreNotFound() {
        Long idChambre = 1L;
        when(chambreRepository.findById(idChambre)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> chambreService.getchambre(idChambre));
        verify(chambreRepository, times(1)).findById(idChambre);
    }
}
