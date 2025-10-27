package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RuoloEntityTest {

	@Test
	void gettersEqualsRoleTest() {
		Ruolo a = new Ruolo("ROLE_USER");
		Ruolo b = new Ruolo("ROLE_USER");
		Ruolo c = new Ruolo("ROLE_ADMIN");

		assertEquals("ROLE_USER", a.getNome());

		assertTrue(a.equals(a));
		assertFalse(a.equals(null));
		assertFalse(a.equals(new Object()));

		a.equals(b);
		a.equals(c);

		a.hashCode();
		assertNotNull(a.toString());
	}
}
