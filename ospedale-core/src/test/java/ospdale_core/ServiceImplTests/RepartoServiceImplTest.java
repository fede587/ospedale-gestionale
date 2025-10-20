package ospdale_core.ServiceImplTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.repository.RepartoRepository;
import ospedale_core.service.impl.RepartoServiceImpl;

class RepartoServiceImplTest {

    @Mock
    RepartoRepository repartoRepository;

    @InjectMocks
    RepartoServiceImpl service;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_delegatesToRepo() {
        Reparto r = new Reparto("Cardio","c");
        when(repartoRepository.findById(5L)).thenReturn(Optional.of(r));

        assertTrue(service.findById(5L).isPresent());
        assertSame(r, service.findById(5L).get());
        verify(repartoRepository, atLeastOnce()).findById(5L);
    }
}
