package ospedale.ospedale_core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Ruolo;

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
