package com.fede587.ospedale.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;

import java.util.List;

public interface DottoreRepository extends JpaRepository<Dottore, Long> {

  
    List<Dottore> findByRepartoId(Long repartoId);

  
    List<Dottore> findByReparto(Reparto reparto);
}
