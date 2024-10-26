

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import tn.esprit._5infini1projetdevops.Entity.Universite;

import tn.esprit._5infini1projetdevops.Repository.UniversiteRepository;
import tn.esprit._5infini1projetdevops.Repository.FoyerRepository;
import tn.esprit._5infini1projetdevops.services.ServiceUniversite;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UniversityServiceTest {

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private ServiceUniversite serviceUniversite;

    @Test
    public void testAddUniversite() {
        Universite mockUniversite = new Universite();
        mockUniversite.setId(1L);
        mockUniversite.setNomUniversite("Test University");

        when(universiteRepository.save(any(Universite.class))).thenReturn(mockUniversite);

        Universite savedUniversite = serviceUniversite.addUniversite(mockUniversite);

        assertNotNull(savedUniversite);
        assertEquals("Test University", savedUniversite.getNomUniversite());
        verify(universiteRepository, times(1)).save(mockUniversite);
    }

    @Test
    public void testGetAllUniversites() {
        Universite uni1 = new Universite();
        uni1.setNomUniversite("Uni 1");
        Universite uni2 = new Universite();
        uni2.setNomUniversite("Uni 2");
        List<Universite> expectedUniversites = Arrays.asList(uni1, uni2);

        when(universiteRepository.findAll()).thenReturn(expectedUniversites);

        List<Universite> result = serviceUniversite.getAlluniversites();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(universiteRepository, times(1)).findAll();
    }

    @Test
    public void testGetUniversiteById() {
        Universite expectedUniversite = new Universite();
        expectedUniversite.setIdUniversite(1L);
        expectedUniversite.setNomUniversite("Test University");

        when(universiteRepository.findById(1L)).thenReturn(Optional.of(expectedUniversite));

        Universite result = serviceUniversite.getuniversite(1L);

        assertNotNull(result);
        assertEquals("Test University", result.getNomUniversite());
        verify(universiteRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteUniversiteById() {
        Long universiteId = 1L;

        serviceUniversite.deleteUniversite(universiteId);

        verify(universiteRepository, times(1)).deleteById(universiteId);
    }

}

