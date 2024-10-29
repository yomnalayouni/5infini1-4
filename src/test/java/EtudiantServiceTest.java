import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit._5infini1projetdevops.Entity.Etudiant;
import tn.esprit._5infini1projetdevops.Repository.EtudiantRepository;
import tn.esprit._5infini1projetdevops.services.EtudiantService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EtudiantServiceTest {

    @Mock
    private EtudiantRepository repo;

    @InjectMocks
    private EtudiantService etudiantService;

    private Etudiant etudiant;

    @BeforeEach
    void setUp() {
        etudiant = new Etudiant();
        etudiant.setIdEtudiant(1L);
        etudiant.setNomEt("Test Name");
        // Set other attributes if necessary
    }

    @Test
     void testAddOrUpdate() {
        // Arrange
        when(repo.save(any(Etudiant.class))).thenReturn(etudiant);

        // Act
        Etudiant result = etudiantService.addOrUpdate(etudiant);

        // Assert
        assertEquals(etudiant, result);
        verify(repo, times(1)).save(etudiant);
    }

    @Test
     void testFindAll() {
        // Arrange
        List<Etudiant> etudiants = Arrays.asList(etudiant);
        when(repo.findAll()).thenReturn(etudiants);

        // Act
        List<Etudiant> result = etudiantService.findAll();

        // Assert
        assertEquals(etudiants, result);
    }

    @Test
    void testFindById() {
        // Arrange
        when(repo.findById(1L)).thenReturn(Optional.of(etudiant));

        // Act
        Etudiant result = etudiantService.findById(1L);

        // Assert
        assertEquals(etudiant, result);
    }

    @Test
     void testDeleteById() {
        // Arrange
        Long id = 1L;

        // Act
        etudiantService.deleteById(id);

        // Assert
        verify(repo, times(1)).deleteById(id);
    }

    @Test
     void testDelete() {
        // Arrange
        // No specific setup needed, just use the existing etudiant object

        // Act
        etudiantService.delete(etudiant);

        // Assert
        verify(repo, times(1)).delete(etudiant);
    }
}
