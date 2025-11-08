package com.fede587.ospedale.web.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.service.RepartoService;

class RepartoControllerExtraTest {

	@Mock
	RepartoService repartoService;

	MockMvc mockMvc;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		RepartoController controller = new RepartoController(repartoService);
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/templates/");
		vr.setSuffix(".html");
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(vr).build();
	}

	@Test
	@DisplayName("GET /reparti -> lista")
	void lista_ok() throws Exception {
		mockMvc.perform(get("/reparti")).andExpect(status().isOk()).andExpect(view().name("reparti/repartiList"))
				.andExpect(model().attributeExists("reparti"));
	}

	@Test
	@DisplayName("GET /reparti/nuovo -> mostra form")
	void nuovo_form_ok() throws Exception {
		mockMvc.perform(get("/reparti/nuovo")).andExpect(status().isOk()).andExpect(view().name("reparti/repartiForm"))
				.andExpect(model().attributeExists("reparto"));
	}

	@Test
	@DisplayName("GET /reparti/{id}/modifica -> redirect se non trovato")
	void modifica_nonTrovato_redirect() throws Exception {
		mockMvc.perform(get("/reparti/999/modifica")).andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/reparti"));
	}

	@Test
	@DisplayName("POST /reparti/{id}/elimina -> presente -> success")
	void elimina_presente() throws Exception {
		when(repartoService.findById(5L)).thenReturn(Optional.of(new Reparto("R", "d")));
		mockMvc.perform(post("/reparti/5/elimina")).andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/reparti")).andExpect(flash().attributeExists("success"));

		verify(repartoService).deleteById(5L);
	}

}
