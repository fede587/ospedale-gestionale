package com.fede587.ospedale.core.service;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.DottoreRepository;
import com.fede587.ospedale.core.service.impl.DottoreServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DottoreServiceImplTest {

    @Mock DottoreRepository dottoreRepository;
    @InjectMocks DottoreServiceImpl service;

    @Test
    void save_chiama_repository_e_preserva_reparto() {
        Reparto r = new Reparto("Cardiologia", "Cuore"); r.setId(1L);
        Dottore dr = new Dottore();
        dr.setNome("Mario"); dr.setCognome("Rossi");
        dr.setReparto(r);

        service.save(dr);

        ArgumentCaptor<Dottore> cap = ArgumentCaptor.forClass(Dottore.class);
        verify(dottoreRepository).save(cap.capture());
        assertThat(cap.getValue().getReparto().getId()).isEqualTo(1L);
    }
}
