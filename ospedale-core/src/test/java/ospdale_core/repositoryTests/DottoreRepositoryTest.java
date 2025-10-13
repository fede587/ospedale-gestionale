package ospdale_core.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.repository.*;
import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;

public class DottoreRepositoryTest {

	RepartoRepository repartoRepo;
	DottoreRepository dottoreRepo;

	@Test
	void salva_e_trova_per_reparto() {

		Reparto cardiologia = new Reparto("Cardiologia", "Cuore");
		repartoRepo.save(cardiologia);

		Dottore dr = new Dottore();
		dr.setNome("Mario");
		dr.setCognome("Rossi");
		dr.setSpecializzazione("Cardiologia");
		dottoreRepo.save(dr);

		List<Dottore> trovati = dottoreRepo.findByReparto(cardiologia);

		assertThat(trovati).extracting(Dottore::getCognome).containsExactly("Rossi");
	}

}
