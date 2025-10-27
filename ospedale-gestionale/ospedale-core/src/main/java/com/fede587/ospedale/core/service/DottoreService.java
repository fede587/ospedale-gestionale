package com.fede587.ospedale.core.service;

import java.util.List;
import java.util.Optional;

import com.fede587.ospedale.core.entity.Dottore;

public interface DottoreService {
    List<Dottore> findAll();
    Optional<Dottore> findById(Long id);
    Dottore save(Dottore dr);
    void deleteById(Long id);
    List<Dottore> findByReparto(Long repartoId);
}
