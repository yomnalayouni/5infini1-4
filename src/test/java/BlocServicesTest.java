
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit._5infini1projetdevops.Entity.Bloc;
import tn.esprit._5infini1projetdevops.Repository.BlocRepository;
import tn.esprit._5infini1projetdevops.services.BlocService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BlocServicesTest {

    @Mock
    private BlocRepository blocRepository;

    @InjectMocks
    private BlocService blocService;

    private Bloc bloc;

    @BeforeEach
    public void setUp() {
        bloc = new Bloc();
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(50L);
    }

    @Test
    public void testAddBloc() {
        // Arrange
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Act
        Bloc savedBloc = blocService.addBloc(bloc);

        // Assert
        assertEquals(bloc, savedBloc);
    }

    /*@Test
    public void testUpdateBloc() {
        // Arrange
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Act
        Bloc updatedBloc = new Bloc();
        updatedBloc.setIdBloc(1L);
        updatedBloc.setNomBloc("Updated Bloc A");
        Bloc savedBloc = blocService.updateBloc(updatedBloc);

        // Assert
        assertEquals("Updated Bloc A", savedBloc.getNomBloc());
    }
*/
    @Test
    public void testUpdateBloc() {
        // Arrange
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));  // Ajoutez ceci pour simuler la récupération du bloc existant
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Act
        Bloc updatedBloc = new Bloc();
        updatedBloc.setIdBloc(1L);
        updatedBloc.setNomBloc("Updated Bloc A");
        Bloc savedBloc = blocService.updateBloc(updatedBloc);

        // Assert
        assertEquals("Updated Bloc A", savedBloc.getNomBloc());
    }

    @Test
    public void testGetAllBlocs() {
        // Arrange
        List<Bloc> blocs = new ArrayList<>();
        blocs.add(bloc);
        when(blocRepository.findAll()).thenReturn(blocs);

        // Act
        List<Bloc> result = blocService.getAllblocs();

        // Assert
        assertEquals(1, result.size());
        assertEquals(bloc, result.get(0));
    }

    @Test
    public void testGetBloc() {
        // Arrange
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Act
        Bloc result = blocService.getbloc(1L);

        // Assert
        assertEquals(bloc, result);
    }

    @Test
    public void testDeleteBloc() {
        // Arrange

        // Act
        blocService.deleteBloc(1L);

        // Assert
        verify(blocRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindBlocsByNomAndCapacite() {
        // Arrange
        List<Bloc> blocs = new ArrayList<>();
        blocs.add(bloc);
        when(blocRepository.findAllByNomBlocIsAndCapaciteBloc("Bloc A", 50L)).thenReturn(blocs);

        // Act
        List<Bloc> result = blocService.trouverBlocsParNomEtCap("Bloc A", 50L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(bloc, result.get(0));
    }
}
