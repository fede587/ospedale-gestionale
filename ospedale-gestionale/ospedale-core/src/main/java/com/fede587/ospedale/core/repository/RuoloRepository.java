package com.fede587.ospedale.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fede587.ospedale.core.entity.Ruolo;

import java.util.Optional;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
    Optional<Ruolo> findByNome(String nome);
}
