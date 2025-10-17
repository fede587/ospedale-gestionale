package ospdale.ospedale_core.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.repository.RepartoRepository;
import ospedale.ospedale_core.service.RepartoService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RepartoServiceTest {

    @Mock RepartoRepository repo;
    @InjectMocks RepartoService service;

    @Test
    void save_callsRepository() {
        Reparto r = new Reparto("Ortopedia", "Ossa");
        service.save(r);
        ArgumentCaptor<Reparto> cap = ArgumentCaptor.forClass(Reparto.class);
        verify(repo).save(cap.capture());
        assertThat(cap.getValue().getNome()).isEqualTo("Ortopedia");
    }
}
