package com.fede587.ospedale.core;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.RepartoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

@org.springframework.test.context.ContextConfiguration(classes = RepartoRepositoryTest.class)

@SpringBootConfiguration
@EnableAutoConfiguration
@Configuration
@EntityScan(basePackages = "com.fede587.ospedale.core.entity")

class RepartoRepositoryTest {

	@Autowired
	RepartoRepository repo;

	@Test
	void saveAndFindByNomeIgnoreCase() {
		Reparto r = new Reparto("Cardiologia", "Cuore");
		repo.save(r);
		assertThat(repo.findByNomeIgnoreCase("cardiologia")).isPresent();
	}
}
