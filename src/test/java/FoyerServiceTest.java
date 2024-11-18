
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit._5infini1projetdevops.Application;
import tn.esprit._5infini1projetdevops.Entity.Bloc;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.Repository.BlocRepository;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.services.FoyerService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
@ContextConfiguration(classes = Application.class)
@ExtendWith(MockitoExtension.class)
 class FoyerServiceTest {

    @Mock
    private FoyerRepository foyerRepository;

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private BlocRepository blocRepository;

    @InjectMocks
    private FoyerService foyerService;

    private Foyer foyer;
    private Universite universite;
    private Bloc bloc;

    @BeforeEach
    public void setUp() {
        foyer = new Foyer();
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Foyer A");
        foyer.setCapaciteFoyer(50L);
        foyer.setBlocs(new ArrayList<>());

        universite = new Universite();
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Université XYZ");

        bloc = new Bloc();
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc 1");

        foyer.setUniversite(universite);
        foyer.getBlocs().add(bloc);
    }

    @Test
    void testFindById_NotFound() {
        // Arrange
        when(foyerRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> foyerService.findById(999L));
    }

    @Test
    void testAddOrUpdate() {
        // Arrange
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        // Act
        Foyer savedFoyer = foyerService.addOrUpdate(foyer);

        // Assert
        assertEquals(foyer, savedFoyer);
        verify(foyerRepository, times(1)).save(foyer);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Foyer> foyers = new ArrayList<>();
        foyers.add(foyer);
        when(foyerRepository.findAll()).thenReturn(foyers);

        // Act
        List<Foyer> result = foyerService.findAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals(foyer, result.get(0));
    }

    @Test
    void testFindById() {
        // Arrange
        when(foyerRepository.findById(1L)).thenReturn(Optional.of(foyer));

        // Act
        Foyer result = foyerService.findById(1L);

        // Assert
        assertEquals(foyer, result);
    }

    @Test
    void testDeleteById() {
        // Act
        foyerService.deleteById(1L);

        // Assert
        verify(foyerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDelete() {
        // Act
        foyerService.delete(foyer);

        // Assert
        verify(foyerRepository, times(1)).delete(foyer);
    }

    @Test
    void testDesaffecterFoyerAUniversite() {
        // Arrange
        when(universiteRepository.findById(1L)).thenReturn(Optional.of(universite));
        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);

        // Act
        Universite updatedUniversite = foyerService.desaffecterFoyerAUniversite(1L);

        // Assert
        assertNull(updatedUniversite.getFoyer());
    }

    @Test
    void testDesaffecterFoyerAUniversite_NotFound() {
        // Arrange
        when(universiteRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> foyerService.desaffecterFoyerAUniversite(999L));
    }

    @Test
    void testAffecterFoyerAUniversite() {
        Universite result = foyerService.affecterFoyerAUniversite(1L, "Université XYZ");
        assertNull(result);  // Method currently returns null
    }

    @Test
    void testAjouterFoyerEtAffecterAUniversite() {
        Foyer result = foyerService.ajouterFoyerEtAffecterAUniversite(foyer, 1L);
        assertNull(result);  // Method currently returns null
    }

    @Test
    void testAjoutFoyerEtBlocs() {
        Foyer result = foyerService.ajoutFoyerEtBlocs(foyer);
        assertNull(result);  // Method currently returns null
    }

    @Test
    void testAddOrUpdate_MinCapacity() {
        // Arrange
        foyer.setCapaciteFoyer(0L); // Edge case: minimum capacity
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        // Act
        Foyer result = foyerService.addOrUpdate(foyer);

        // Assert
        assertEquals(0L, result.getCapaciteFoyer());
    }
    @Test
    void contextLoads() {
        assertNotNull(foyerService, "foyerService should be autowired and not null");
    }
}
