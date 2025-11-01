package com.fede587.ospedale.core.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.RepartoRepository;

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
    void findAll_returnsRepoList() {
        List<Reparto> data = List.of(new Reparto("Cardio","c"), new Reparto("Ortopedia","o"));
        when(repartoRepository.findAll()).thenReturn(data);

        List<Reparto> res = service.findAll();
        assertEquals(2, res.size());
        assertSame(data, res);
    }

    @Test
    void findById_delegatesToRepo() {
        Reparto r = new Reparto("Cardio","c");
        when(repartoRepository.findById(5L)).thenReturn(Optional.of(r));

        assertTrue(service.findById(5L).isPresent());
        assertSame(r, service.findById(5L).get());
        verify(repartoRepository, atLeastOnce()).findById(5L);
    }

    @Test
    void save_delegatesToRepo() {
        Reparto r = new Reparto("Cardio","c");
        when(repartoRepository.save(r)).thenReturn(r);

        Reparto saved = service.save(r);
        assertSame(r, saved);
        verify(repartoRepository).save(r);
    }

    @Test
    void deleteById_delegatesToRepo() {
        service.deleteById(9L);
        verify(repartoRepository).deleteById(9L);
    }
}
