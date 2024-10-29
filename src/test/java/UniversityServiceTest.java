import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit._5infini1projetdevops.Entity.Foyer;
import tn.esprit._5infini1projetdevops.Entity.Universite;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.services.ServiceUniversite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UniversityServiceTest {

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private ServiceUniversite serviceUniversite;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUniversite() {
        Universite universite = new Universite();
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Test University");

        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);

        Universite result = serviceUniversite.addUniversite(universite);

        assertNotNull(result);
        assertEquals("Test University", result.getNomUniversite());
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    public void testDeleteUniversite() {
        Long universiteId = 1L;

        doNothing().when(universiteRepository).deleteById(universiteId);

        serviceUniversite.deleteUniversite(universiteId);

        verify(universiteRepository, times(1)).deleteById(universiteId);
    }

    @Test
    public void testUpdateUniversite() {
        Universite universite = new Universite();
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Updated University");

        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);

        Universite result = serviceUniversite.updateUniversite(universite);

        assertNotNull(result);
        assertEquals("Updated University", result.getNomUniversite());
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    public void testGetAllUniversites() {
        Universite uni1 = new Universite();
        uni1.setIdUniversite(1L);
        uni1.setNomUniversite("University 1");

        Universite uni2 = new Universite();
        uni2.setIdUniversite(2L);
        uni2.setNomUniversite("University 2");

        List<Universite> universiteList = new ArrayList<>();
        universiteList.add(uni1);
        universiteList.add(uni2);

        when(universiteRepository.findAll()).thenReturn(universiteList);

        List<Universite> result = serviceUniversite.getAlluniversites();

        assertEquals(2, result.size());
        verify(universiteRepository, times(1)).findAll();
    }

    @Test
    public void testGetUniversiteById() {
        Universite universite = new Universite();
        universite.setIdUniversite(1L);
        universite.setNomUniversite("Test University");

        when(universiteRepository.findById(1L)).thenReturn(Optional.of(universite));

        Universite result = serviceUniversite.getuniversite(1L);

        assertNotNull(result);
        assertEquals("Test University", result.getNomUniversite());
        verify(universiteRepository, times(1)).findById(1L);
    }

    @Test
    public void testAssignFoyerToUniversite() {
        Long universiteId = 1L;
        Long foyerId = 1L;

        Universite universite = new Universite();
        universite.setIdUniversite(universiteId);

        Foyer foyer = new Foyer();
        foyer.setIdFoyer(foyerId);

        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(universite));
        when(foyerRepository.findById(foyerId)).thenReturn(Optional.of(foyer));

        serviceUniversite.assignFoyerToUniversite(universiteId, foyerId);

        assertEquals(foyer, universite.getFoyer());
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    public void testUnassignFoyerFromUniversite() {
        Long universiteId = 1L;

        Universite universite = new Universite();
        universite.setIdUniversite(universiteId);
        universite.setFoyer(new Foyer());

        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(universite));

        serviceUniversite.unassignFoyerToUniversite(universiteId);

        assertNull(universite.getFoyer());
        verify(universiteRepository, times(1)).save(universite);
    }
}
