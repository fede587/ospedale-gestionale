package com.fede587.ospedale.core.service.impl;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.DottoreRepository;
import com.fede587.ospedale.core.repository.RepartoRepository;
import com.fede587.ospedale.core.service.DottoreService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class DottoreServiceImpl implements DottoreService {
    private final DottoreRepository dottori;
    private final RepartoRepository reparti;
    public DottoreServiceImpl(DottoreRepository dottori, RepartoRepository reparti) {
        this.dottori = dottori; this.reparti = reparti;
    }
    public List<Dottore> findAll(){ return dottori.findAll(); }
    public Optional<Dottore> findById(Long id){ return dottori.findById(id); }
    public Dottore save(Dottore dr){ return dottori.save(dr); }
    public void deleteById(Long id){ dottori.deleteById(id); }
    public List<Dottore> findByReparto(Long repartoId){
        Reparto r = reparti.findById(repartoId).orElseThrow();
        return dottori.findByReparto(r);
    }
}
