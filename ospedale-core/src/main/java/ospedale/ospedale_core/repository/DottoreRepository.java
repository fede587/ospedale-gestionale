package ospedale.ospedale_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;

import java.util.List;

public interface DottoreRepository extends JpaRepository<Dottore, Long> {

	List<Dottore> findByRepartoId(Long repartoId);

	List<Dottore> findByReparto(Reparto reparto);
}
