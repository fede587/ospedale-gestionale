package com.fede587.ospedale.web.bootstrap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.ClienteRepository;
import com.fede587.ospedale.core.repository.RepartoRepository;
import com.fede587.ospedale.core.repository.RuoloRepository;

class DataBootstrapTest {

    @Mock RepartoRepository repartoRepo;
    @Mock ClienteRepository clienti;
    @Mock RuoloRepository ruoli;
    @Mock PasswordEncoder enc;

    @InjectMocks
    DataBootstrap dataBootstrap;

    DataBootstrapTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void run_inserisceRepartiSeMancano() throws Exception {
        when(repartoRepo.count()).thenReturn(5L);
        when(repartoRepo.findByNomeIgnoreCase("Cardiologia")).thenReturn(Optional.empty());
        when(repartoRepo.findByNomeIgnoreCase("Ortopedia")).thenReturn(Optional.empty());

        dataBootstrap.run();

        verify(repartoRepo, atLeast(2)).save(any(Reparto.class));
    }

    @Test
    void run_nonInserisceSeRepartiGiaPresenti() throws Exception {
        when(repartoRepo.count()).thenReturn(5L);
        when(repartoRepo.findByNomeIgnoreCase("Cardiologia")).thenReturn(Optional.of(new Reparto("Cardiologia","Cuore")));
        when(repartoRepo.findByNomeIgnoreCase("Ortopedia")).thenReturn(Optional.of(new Reparto("Ortopedia","Ossa")));

        dataBootstrap.run();

        verify(repartoRepo, never()).save(any());
    }
}
