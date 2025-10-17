package ospdale.ospedale_core.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.repository.DottoreRepository;
import ospedale.ospedale_core.service.DottoreService;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class DottoreServiceTest {

    @Mock DottoreRepository dottoreRepository;
    @InjectMocks DottoreService service;

    @Test
    void save_chiama_repository_e_preserva_reparto() {
        Reparto r = new Reparto("Cardiologia", "Cuore"); r.setId(1L);
        Dottore dr = new Dottore();
        dr.setNome("Mario"); dr.setCognome("Rossi");
        dr.setReparto(r);

        service.save(dr);

        ArgumentCaptor<Dottore> cap = ArgumentCaptor.forClass(Dottore.class);
        verify(dottoreRepository).save(cap.capture());
        assertThat(cap.getValue().getReparto().getId()).isEqualTo(0);
    }
}
