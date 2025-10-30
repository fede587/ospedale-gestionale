package com.fede587.ospedale.core;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.repository.RepartoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;


class RepartoRepositoryTest {

    @Autowired RepartoRepository repo;

    @Test
    void saveAndFindByNomeIgnoreCase() {
        Reparto r = new Reparto("Cardiologia", "Cuore");
        repo.save(r);
        assertThat(repo.findByNomeIgnoreCase("cardiologia")).isPresent();
    }
}
