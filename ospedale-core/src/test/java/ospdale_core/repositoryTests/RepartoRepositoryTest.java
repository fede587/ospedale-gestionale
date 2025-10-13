package ospdale_core.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.repository.RepartoRepository;

public class RepartoRepositoryTest {
	
	RepartoRepository repository;
	
    @Test
    void testfindByNomeIgnoreCase() {
        Reparto r = new Reparto("Cardiologia", "Cuore");
        repository.save(r);
        assertThat(repository.findByNomeIgnoreCase("cardiologia")).isPresent();
    }

}
