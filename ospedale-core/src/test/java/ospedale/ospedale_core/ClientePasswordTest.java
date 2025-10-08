package ospedale.ospedale_core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Cliente;

class UtenteCtorAndPasswordNullTest {

	@Test
	void usernamePassword_getId_setPasswordNull() {
		Cliente client = new Cliente("fede", "password");
		assertEquals("fede", client.getUsername());
		assertEquals("password", client.getPassword());

		assertNull(client.getId());

		client.setPassword(null);
		assertNull(client.getPassword());
	}
}
