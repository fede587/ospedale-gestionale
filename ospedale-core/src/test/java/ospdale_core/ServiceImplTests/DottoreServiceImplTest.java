package ospdale_core.ServiceImplTests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.repository.DottoreRepository;
import ospedale_core.service.impl.DottoreServiceImpl;

class dottoreServiceImplTest {

    @Mock DottoreRepository dottoreRepository;

    @InjectMocks DottoreServiceImpl service;

    @Test
    void findAll_delegatesToRepo() {
        when(dottoreRepository.findAll()).thenReturn(List.of(new Dottore(), new Dottore()));
        assertEquals(2, service.findAll().size());
    }
}
