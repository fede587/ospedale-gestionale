package ospedale.ospedale_core.EntityTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Reparto;

class RepartoEntityTest {

	@Test
	void gettersSettersTestReparto() {
		Reparto r1 = new Reparto();
		r1.setNome("Cardiologia");
		r1.setDescrizione("Cuore");

		Reparto r2 = new Reparto();
		r2.setNome("Cardiologia");
		r2.setDescrizione("Cuore");

		assertEquals("Cardiologia", r1.getNome());
		assertEquals("Cuore", r1.getDescrizione());

		assertTrue(r1.equals(r1));
		assertFalse(r1.equals(null));
		assertFalse(r1.equals(new Object()));

		r1.equals(r2);

		r1.hashCode();
		assertNotNull(r1.toString());
	}
}
