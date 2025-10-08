package ospedale.ospedale_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ospedale.ospedale_core.entità.Ruolo;

import java.util.Optional;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
    Optional<Ruolo> findByNome(String nome);
}
