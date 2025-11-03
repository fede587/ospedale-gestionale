package com.fede587.ospedale.web;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.service.RepartoService;
import com.fede587.ospedale.web.controller.RepartoController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RepartoControllerTest {

  private MockMvc mockMvc;
  private RepartoService repartoService;

  @BeforeEach
  void setUp() {
    repartoService = Mockito.mock(RepartoService.class);
    RepartoController controller = new RepartoController(repartoService);
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); 
  }

  @Test
  void lista_ok() throws Exception {
    when(repartoService.findAll()).thenReturn(List.of(
      new Reparto("Cardiologia","Cuore"),
      new Reparto("Ortopedia","Ossa")
    ));

    mockMvc.perform(get("/reparti"))
           .andExpect(status().isOk());
           
  }

  @Test
  void crea_ok() throws Exception {
    mockMvc.perform(post("/reparti")
        .param("nome","Cardiologia")
        .param("descrizione","Cuore"))
      .andExpect(status().is3xxRedirection());
      

    var cap = ArgumentCaptor.forClass(Reparto.class);
    Mockito.verify(repartoService).save(cap.capture());
    assertThat(cap.getValue().getNome()).isEqualTo("Cardiologia");
  }

  @Test
  void modifica_ok() throws Exception {
    Reparto r = new Reparto("Ortopedia","Ossa"); r.setId(10L);
    when(repartoService.findById(10L)).thenReturn(Optional.of(r));

    mockMvc.perform(get("/reparti/10/modifica"))
           .andExpect(status().isOk());
           
  }
}
