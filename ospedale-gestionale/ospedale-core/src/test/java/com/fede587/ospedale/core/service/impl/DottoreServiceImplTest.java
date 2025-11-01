package com.fede587.ospedale.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.DottoreRepository;
import com.fede587.ospedale.core.repository.RepartoRepository;

class DottoreServiceImplTest {

    @Mock DottoreRepository dottoreRepository;
    @Mock RepartoRepository repartoRepository;

    @InjectMocks DottoreServiceImpl service;

    @BeforeEach
    void init() { MockitoAnnotations.openMocks(this); }

    @Test
    void findAll_delegatesToRepo() {
        when(dottoreRepository.findAll()).thenReturn(List.of(new Dottore(), new Dottore()));
        assertEquals(2, service.findAll().size());
    }

    @Test
    void findById_delegatesToRepo() {
        Dottore dr = new Dottore();
        when(dottoreRepository.findById(3L)).thenReturn(Optional.of(dr));
        assertTrue(service.findById(3L).isPresent());
        assertSame(dr, service.findById(3L).get());
    }

    @Test
    void deleteById_delegatesToRepo() {
        service.deleteById(7L);
        verify(dottoreRepository).deleteById(7L);
    }

    @Test
    void save_delegatesToRepo() {
        Dottore dr = new Dottore();
        when(dottoreRepository.save(dr)).thenReturn(dr);
        assertSame(dr, service.save(dr));
    }

    @Test
    void findByReparto_usesRepartoEntityFromRepo() {
       
        Reparto reparto = new Reparto();
        reparto.setId(5L);
        when(repartoRepository.findById(5L)).thenReturn(Optional.of(reparto));
        when(dottoreRepository.findByReparto(reparto)).thenReturn(List.of(new Dottore(), new Dottore()));

        assertEquals(2, service.findByReparto(5L).size());
        verify(repartoRepository).findById(5L);
        verify(dottoreRepository).findByReparto(reparto);
    }
}
