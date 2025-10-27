package com.fede587.ospedale.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fede587.ospedale.core.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByUsername(String username);
}
