package com.fede587.ospedale.core.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;

@DataJpaTest
@ContextConfiguration(classes = DottoreRepositoryTest.TestBootConfig.class)

class DottoreRepositoryTest {

	@SpringBootConfiguration
	@EnableAutoConfiguration
	@Configuration
	@EntityScan("com.fede587.ospedale.core.entity")
	@EnableJpaRepositories("com.fede587.ospedale.core.repository")
	static class TestBootConfig {
	}

	@Autowired
	RepartoRepository repartoRepo;
	@Autowired
	DottoreRepository dottoreRepo;

	@Test
	void salva_e_trova_per_reparto_entity() {

		Reparto orto = new Reparto("Ortopedia", "Ossa");
		repartoRepo.save(orto);

		Dottore dr = new Dottore();
		dr.setNome("Luca");
		dr.setCognome("Bianchi");
		dr.setSpecializzazione("Ortopedia");
		dr.setReparto(orto);
		dottoreRepo.save(dr);

		List<Dottore> trovati = dottoreRepo.findByReparto(orto);

		assertThat(trovati).extracting(Dottore::getCognome).containsExactly("Bianchi");
	}
}
