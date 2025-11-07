package com.fede587.ospedale.web.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.service.DottoreService;
import com.fede587.ospedale.core.service.RepartoService;

class DottoreControllerExtraTest {

    @Mock RepartoService repartoService;
    @Mock DottoreService dottoreService;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        DottoreController controller = new DottoreController(dottoreService, repartoService);
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/templates/");
        vr.setSuffix(".html");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(vr).build();
    }

    @Test
    void getNuovo_form_ok() throws Exception {
        mockMvc.perform(get("dottori/dottoriForm"))
            .andExpect(status().isOk())
            .andExpect(view().name("dottori/dottoriForm"))
            .andExpect(model().attributeExists("dottore"));
    }

    @Test
    void creaDottore_ok_redirect() throws Exception {
        when(repartoService.findById(anyLong())).thenReturn(Optional.of(new Reparto("Cardio","C")));
        mockMvc.perform(post("/dottori")
                .param("nome","Mario")
                .param("cognome","Rossi")
                .param("repartoId","1"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/dottori"));
    }
}
