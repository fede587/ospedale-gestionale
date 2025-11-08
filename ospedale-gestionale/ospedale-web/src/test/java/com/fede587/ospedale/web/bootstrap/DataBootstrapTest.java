package com.fede587.ospedale.web.bootstrap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fede587.ospedale.core.entity.Cliente;
import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.entity.Ruolo;
import com.fede587.ospedale.core.repository.ClienteRepository;
import com.fede587.ospedale.core.repository.RepartoRepository;
import com.fede587.ospedale.core.repository.RuoloRepository;

class DataBootstrapTest {

	@Mock
	RepartoRepository repartoRepo;
	@Mock
	ClienteRepository clienti;
	@Mock
	RuoloRepository ruoli;
	@Mock
	PasswordEncoder enc;

	@InjectMocks
	DataBootstrap dataBootstrap;

	DataBootstrapTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void run_inserisceRepartiSeMancano() throws Exception {
		when(repartoRepo.count()).thenReturn(5L);
		when(repartoRepo.findByNomeIgnoreCase("Cardiologia")).thenReturn(Optional.empty());
		when(repartoRepo.findByNomeIgnoreCase("Ortopedia")).thenReturn(Optional.empty());

		dataBootstrap.run();

		verify(repartoRepo, atLeast(2)).save(any(Reparto.class));
	}

	@Test
	void run_nonInserisceSeRepartiGiaPresenti() throws Exception {
		when(repartoRepo.count()).thenReturn(5L);
		when(repartoRepo.findByNomeIgnoreCase("Cardiologia"))
				.thenReturn(Optional.of(new Reparto("Cardiologia", "Cuore")));
		when(repartoRepo.findByNomeIgnoreCase("Ortopedia")).thenReturn(Optional.of(new Reparto("Ortopedia", "Ossa")));

		dataBootstrap.run();

		verify(repartoRepo, never()).save(any());
	}

	@Test
	void run_creaRuoliEUtenteSeMancano() throws Exception {
		when(ruoli.findByNome("ROLE_USER")).thenReturn(Optional.empty());
		when(ruoli.findByNome("ROLE_ADMIN")).thenReturn(Optional.empty());
		when(clienti.findByUsername("admin")).thenReturn(Optional.empty());
		when(enc.encode(anyString())).thenReturn("ENC");

		dataBootstrap.run();

		ArgumentCaptor<Ruolo> ruoloCaptor = ArgumentCaptor.forClass(Ruolo.class);
		verify(ruoli, times(2)).save(ruoloCaptor.capture());
		Set<String> savedNames = ruoloCaptor.getAllValues().stream().map(Ruolo::getNome).collect(Collectors.toSet());
		org.junit.jupiter.api.Assertions.assertTrue(savedNames.containsAll(Set.of("ROLE_USER", "ROLE_ADMIN")));

		verify(enc).encode("password");
		verify(clienti, times(1)).save(any(Cliente.class));
	}

	@Test
	void run_nonCreaRuoliEUtenteSeGiaPresenti() throws Exception {
		when(ruoli.findByNome("ROLE_USER")).thenReturn(Optional.of(new Ruolo("ROLE_USER")));
		when(ruoli.findByNome("ROLE_ADMIN")).thenReturn(Optional.of(new Ruolo("ROLE_ADMIN")));
		when(clienti.findByUsername("admin")).thenReturn(Optional.of(new Cliente("admin", "ENC")));

		dataBootstrap.run();

		verify(ruoli, never()).save(any());
		verify(clienti, never()).save(any());
	}
}
