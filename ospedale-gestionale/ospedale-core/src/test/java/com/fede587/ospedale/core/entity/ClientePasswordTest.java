package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ClientePasswordTest {

	class UtenteCtorAndPasswordNullTest {

		@Test
		void usernamePassword_getId_setPasswordNull() {
			Cliente cl = new Cliente("fede", "password");
			assertEquals("fede", cl.getUsername());
			assertEquals("password", cl.getPassword());

			assertNull(cl.getId());

			cl.setPassword(null);
			assertNull(cl.getPassword());
		}
	}
}