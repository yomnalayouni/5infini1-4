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

import static org.junit.jupiter.api.Assertions.*;
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
        verify(blocRepository, times(1)).save(bloc);
    }

    @Test
    public void testDeleteBloc() {
        // Act
        blocService.deleteBloc(1L);

        // Assert
        verify(blocRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateBlocSuccess() {
        // Arrange
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Act
        Bloc updatedBloc = new Bloc();
        updatedBloc.setIdBloc(1L);
        updatedBloc.setNomBloc("Updated Bloc A");
        updatedBloc.setCapaciteBloc(60L);
        Bloc result = blocService.updateBloc(updatedBloc);

        // Assert
        assertEquals("Updated Bloc A", result.getNomBloc());
        assertEquals(60L, result.getCapaciteBloc());
        verify(blocRepository, times(1)).findById(1L);
        verify(blocRepository, times(1)).save(bloc);
    }

    @Test
    public void testUpdateBlocNotFound() {
        // Arrange
        when(blocRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            blocService.updateBloc(bloc);
        });
        assertEquals("Bloc not found", exception.getMessage());
        verify(blocRepository, times(1)).findById(1L);
        verify(blocRepository, never()).save(any(Bloc.class));
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
        verify(blocRepository, times(1)).findAll();
    }

    @Test
    public void testGetBlocByIdSuccess() {
        // Arrange
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Act
        Bloc result = blocService.getbloc(1L);

        // Assert
        assertEquals(bloc, result);
        verify(blocRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetBlocByIdNotFound() {
        // Arrange
        when(blocRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Bloc result = blocService.getbloc(1L);

        // Assert
        assertNull(result);
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
        verify(blocRepository, times(1)).findAllByNomBlocIsAndCapaciteBloc("Bloc A", 50L);
    }
}
