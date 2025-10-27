package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DottoreEntityTest {

	@Test
	void gettersSetters_equals_branches_hashCode_toString() {
		Reparto reparto = new Reparto();
		reparto.setNome("Cardio");

		Dottore dr1 = new Dottore();
		dr1.setNome("Mario");
		dr1.setCognome("Rossi");
		dr1.setEmail("mario.rossi@example.com");
		dr1.setTelefono("0123");
		dr1.setSpecializzazione("Cardiologia");
		dr1.setReparto(reparto);

		Dottore dr2 = new Dottore();
		dr2.setNome("Mario");
		dr2.setCognome("Rossi");
		dr2.setEmail("mario.rossi@example.com");
		dr2.setTelefono("0123");
		dr2.setSpecializzazione("Cardiologia");
		dr2.setReparto(reparto);

		assertEquals("Mario", dr1.getNome());
		assertEquals("Rossi", dr1.getCognome());
		assertEquals("mario.rossi@example.com", dr1.getEmail());
		assertEquals("0123", dr1.getTelefono());
		assertEquals("Cardiologia", dr1.getSpecializzazione());
		assertEquals(reparto, dr1.getReparto());

		assertTrue(dr1.equals(dr1));
		assertFalse(dr1.equals(null));
		assertFalse(dr1.equals(new Object()));

		dr1.equals(dr2);

		dr1.hashCode();
		assertNotNull(dr1.toString());
	}
}
