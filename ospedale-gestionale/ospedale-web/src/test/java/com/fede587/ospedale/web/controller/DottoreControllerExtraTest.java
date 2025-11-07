package com.fede587.ospedale.web.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
        DottoreController controller = new DottoreController(dottoreService, repartoService);
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/templates/");
        vr.setSuffix(".html");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(vr).build();
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
