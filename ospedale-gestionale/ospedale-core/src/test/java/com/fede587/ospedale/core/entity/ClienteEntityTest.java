package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ClienteEntityTest {

	@Test
	void gettersSettersClienteTest() {

		Set<Ruolo> ruoli1 = new LinkedHashSet<>();
		ruoli1.add(new Ruolo("ROLE_USER"));
		ruoli1.add(new Ruolo("ROLE_ADMIN"));

		Set<Ruolo> ruoli2 = new LinkedHashSet<>();
		ruoli2.add(new Ruolo("ROLE_USER"));
		ruoli2.add(new Ruolo("ROLE_ADMIN"));

		Cliente c1 = new Cliente();
		c1.setUsername("username");
		c1.setPassword("password");
		c1.setRuoli(ruoli1);

		Cliente c2 = new Cliente();
		c2.setUsername("username");
		c2.setPassword("password");
		c2.setRuoli(ruoli2);

		assertEquals("username", c1.getUsername());
		assertEquals("password", c1.getPassword());
		assertEquals(2, c1.getRuoli().size());

		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(null));
		assertFalse(c1.equals(new Object()));

		c1.equals(c2);

		c1.hashCode();
		assertNotNull(c1.toString());
	}
}
