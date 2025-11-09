package com.fede587.ospedale.core.service;

import com.fede587.ospedale.core.entity.Reparto;

import com.fede587.ospedale.core.repository.RepartoRepository;
import com.fede587.ospedale.core.service.impl.RepartoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RepartoServiceImplTest {

	@Mock
	RepartoRepository repo;
	@InjectMocks
	RepartoServiceImpl service;

	@Test
	void save_callsRepository() {
		Reparto r = new Reparto("Ortopedia", "Ossa");
		service.save(r);
		ArgumentCaptor<Reparto> cap = ArgumentCaptor.forClass(Reparto.class);
		verify(repo).save(cap.capture());
		assertThat(cap.getValue().getNome()).isEqualTo("Ortopedia");
	}
}
