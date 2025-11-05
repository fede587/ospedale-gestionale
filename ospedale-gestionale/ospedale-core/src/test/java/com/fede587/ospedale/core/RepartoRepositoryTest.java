package com.fede587.ospedale.core;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.RepartoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

@org.springframework.test.context.ContextConfiguration(classes = RepartoRepositoryTest.class)

@SpringBootConfiguration
class RepartoRepositoryTest {

    @Autowired RepartoRepository repo;

    @Test
    void saveAndFindByNomeIgnoreCase() {
        Reparto r = new Reparto("Cardiologia", "Cuore");
        repo.save(r);
        assertThat(repo.findByNomeIgnoreCase("cardiologia")).isPresent();
    }
}
