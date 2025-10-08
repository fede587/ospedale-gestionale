package ospedale.ospedale_core.repository;

import ospedale.ospedale_core.entità.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByUsername(String username);
}
