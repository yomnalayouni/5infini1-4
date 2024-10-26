
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit._5infini1projetdevops.Entity.Bloc;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.Repository.BlocRepository;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.services.FoyerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FoyerServiceTest {

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
        foyer.setBlocs(new ArrayList<>()); // Change to ArrayList

        universite = new Universite();
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Université XYZ");

        bloc = new Bloc();
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc 1");

        foyer.setUniversite(universite);
        foyer.getBlocs().add(bloc); // Now, foyer.getBlocs() is a List
    }

    @Test
    public void testAddOrUpdate() {
        // Arrange
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        // Act
        Foyer savedFoyer = foyerService.addOrUpdate(foyer);

        // Assert
        assertEquals(foyer, savedFoyer);
    }

    @Test
    public void testFindAll() {
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
    public void testFindById() {
        // Arrange
        when(foyerRepository.findById(1L)).thenReturn(Optional.of(foyer));

        // Act
        Foyer result = foyerService.findById(1L);

        // Assert
        assertEquals(foyer, result);
    }

    @Test
    public void testDeleteById() {
        // Act
        foyerService.deleteById(1L);

        // Assert
        verify(foyerRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDelete() {
        // Act
        foyerService.delete(foyer);

        // Assert
        verify(foyerRepository, times(1)).delete(foyer);
    }

    @Test
    public void testDesaffecterFoyerAUniversite() {
        // Arrange
        when(universiteRepository.findById(1L)).thenReturn(Optional.of(universite));
        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);

        // Act
        Universite updatedUniversite = foyerService.desaffecterFoyerAUniversite(1L);

        // Assert
        assertEquals(null, updatedUniversite.getFoyer());
    }



}
