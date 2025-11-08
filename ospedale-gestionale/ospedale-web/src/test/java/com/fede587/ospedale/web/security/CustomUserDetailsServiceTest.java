package com.fede587.ospedale.web.security;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fede587.ospedale.core.repository.ClienteRepository;

class CustomUserDetailsServiceTest {

	@Test
	void loadUser_notFound_throws() {
		ClienteRepository clienti = mock(ClienteRepository.class);
		CustomUserDetailsService custom = new CustomUserDetailsService(clienti);
		when(clienti.findByUsername("x")).thenReturn(Optional.empty());

		assertThrows(UsernameNotFoundException.class, () -> custom.loadUserByUsername("x"));
	}
}
