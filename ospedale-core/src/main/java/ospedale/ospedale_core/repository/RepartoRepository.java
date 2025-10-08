package ospedale.ospedale_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ospedale.ospedale_core.entità.Reparto;

import java.util.Optional;

public interface RepartoRepository extends JpaRepository<Reparto, Long> {
	
    Optional<Reparto> findByNomeIgnoreCase(String nome);
    
}
