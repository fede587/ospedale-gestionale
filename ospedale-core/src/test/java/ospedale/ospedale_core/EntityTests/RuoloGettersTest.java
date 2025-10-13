package ospedale.ospedale_core.EntityTests;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Ruolo;

class RuoloIdGetterTest {

	@Test
	void getId_coversGetterEvenIfNull() {
		Ruolo ruolo = new Ruolo("ROLE_USER");
		assertNull(ruolo.getId());
	}
}
