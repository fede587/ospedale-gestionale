package com.fede587.ospedale.core.service;

import java.util.List;
import java.util.Optional;

import com.fede587.ospedale.core.entity.Reparto;

public interface RepartoService {
    List<Reparto> findAll();
    Optional<Reparto> findById(Long id);
    Reparto save(Reparto r);
    void deleteById(Long id);
}
