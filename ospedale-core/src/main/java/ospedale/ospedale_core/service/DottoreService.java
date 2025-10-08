package ospedale.ospedale_core.service;

import java.util.List;
import java.util.Optional;
import ospedale.ospedale_core.entità.Dottore;

interface DottoreService {
	List<Dottore> findAll();

	Optional<Dottore> findById(Long id);

	Dottore save(Dottore dr);

	void deleteById(Long id);

}
