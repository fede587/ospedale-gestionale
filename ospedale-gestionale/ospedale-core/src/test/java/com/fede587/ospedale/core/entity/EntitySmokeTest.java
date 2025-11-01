package com.fede587.ospedale.core.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EntitySmokeTest {

	@Test
	void dottore_getter_setter() {
		Dottore dr = new Dottore();
		dr.setNome("Mario");
		dr.setCognome("Rossi");
		dr.setEmail("mario.rossi@example.com");
		dr.setTelefono("3331234567");
		dr.setSpecializzazione("Cardiologia");
		assertThat(dr.getNome()).isEqualTo("Mario");
		assertThat(dr.getCognome()).isEqualTo("Rossi");
		assertThat(dr.getSpecializzazione()).isEqualTo("Cardiologia");
	}

	@Test
	void reparto_costruttore_e_getter() {
		Reparto r = new Reparto("Cardiologia", "Cuore");
		assertThat(r.getNome()).isEqualTo("Cardiologia");
		assertThat(r.getDescrizione()).isEqualTo("Cuore");
	}

	@Test
	void cliente_ruolo_getter_setter() {
		Ruolo ruolo = new Ruolo();
		ruolo.setNome("ADMIN");
		Cliente cl = new Cliente();
		cl.setUsername("admin");
		cl.setPassword("password");
		assertThat(ruolo.getNome()).isEqualTo("ADMIN");
		assertThat(cl.getUsername()).isEqualTo("admin");
	}
}
