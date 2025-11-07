package com.fede587.ospedale.web.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fede587.ospedale.core.repository.ClienteRepository;
import com.fede587.ospedale.core.repository.RuoloRepository;

class ClienteServiceTest {

    @Mock ClienteRepository clienteRepo;
    @Mock RuoloRepository ruoloRepo;
    @Mock PasswordEncoder passwordEncoder;

    @InjectMocks ClienteService clienteService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registra_admin_ok() {
        when(passwordEncoder.encode(anyString())).thenReturn("ENC");

        clienteService.registra("admin2", "StrongPass1!", true);

        verify(passwordEncoder).encode("StrongPass1!");
        verify(clienteRepo).save(any());
    }
}
