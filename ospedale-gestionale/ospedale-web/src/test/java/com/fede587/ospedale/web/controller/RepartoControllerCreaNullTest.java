package com.fede587.ospedale.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fede587.ospedale.core.service.RepartoService;

class RepartoControllerCreaNullTest {

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
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(vr)
                .build();
    }

    @Test
    @DisplayName("POST /reparti senza 'nome' -> ramo nome == null")
    void crea_nomeNull_rientraInValidazione() throws Exception {
        
        mockMvc.perform(post("/reparti"))
            .andExpect(status().isOk())
            .andExpect(view().name("reparti/form"))
            .andExpect(model().attributeHasFieldErrors("reparto","nome"));
    }
}
