package com.fede587.ospedale.core.service.impl;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.RepartoRepository;
import com.fede587.ospedale.core.service.RepartoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class RepartoServiceImpl implements RepartoService {
    private final RepartoRepository repo;
    public RepartoServiceImpl(RepartoRepository repo){ this.repo = repo; }

    public List<Reparto> findAll(){ return repo.findAll(); }
    public Optional<Reparto> findById(Long id){ return repo.findById(id); }
    public Reparto save(Reparto r){ return repo.save(r); }
    public void deleteById(Long id){ repo.deleteById(id); }
}
