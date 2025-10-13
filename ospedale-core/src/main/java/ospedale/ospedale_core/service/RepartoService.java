package ospedale.ospedale_core.service;

import java.util.List;
import java.util.Optional;
import ospedale.ospedale_core.entità.Reparto;

public interface RepartoService {
	List<Reparto> findAll();

	Optional<Reparto> findById(Long id);

	Reparto save(Reparto reparto);

	void deleteById(Long id);

}
