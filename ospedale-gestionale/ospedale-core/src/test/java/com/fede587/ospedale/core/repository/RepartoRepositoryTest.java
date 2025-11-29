package com.fede587.ospedale.core.repository;


import com.fede587.ospedale.core.entity.Reparto;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

@org.springframework.test.context.ContextConfiguration(classes = RepartoRepositoryTest.TestBootConfig.class)
class RepartoRepositoryTest {
	@SpringBootConfiguration
	@EnableAutoConfiguration
	@Configuration
	@EntityScan(basePackages = "com.fede587.ospedale.core.entity")
	@EnableJpaRepositories(basePackages = "com.fede587.ospedale.core.repository")

	static class TestBootConfig {
	}

	@Autowired
	RepartoRepository repo;

	@Test
	void saveAndFindByNomeIgnoreCase() {
		Reparto r = new Reparto("Cardiologia", "Cuore");
		repo.save(r);
		assertThat(repo.findByNomeIgnoreCase("cardiologia")).isPresent();
	}
}
