package com.fede587.ospedale.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fede587.ospedale.core.entity.Reparto;

import java.util.Optional;

public interface RepartoRepository extends JpaRepository<Reparto, Long> {
    Optional<Reparto> findByNomeIgnoreCase(String nome);
}
