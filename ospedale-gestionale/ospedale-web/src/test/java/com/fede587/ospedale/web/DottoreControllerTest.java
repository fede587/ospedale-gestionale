package com.fede587.ospedale.web;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.service.DottoreService;
import com.fede587.ospedale.core.service.RepartoService;
import com.fede587.ospedale.web.controller.DottoreController;

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
class DottoreControllerTest {

  private MockMvc mockMvc;
  private DottoreService  dottoreService;
  private RepartoService repartoService;

  @BeforeEach
  void setUp() {
    dottoreService  = Mockito.mock(DottoreService.class);
    repartoService = Mockito.mock(RepartoService.class);
    DottoreController controller = new DottoreController(dottoreService, repartoService);
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); 
  }

  @Test
  void mostraFormNuovo() throws Exception {
    when(repartoService.findAll()).thenReturn(List.of(new Reparto("Cardiologia","Cuore")));
    mockMvc.perform(get("/medici/nuovo"))
           .andExpect(status().isOk());
           
  }

  @Test
  void creaDottore_conRepartoId_valido() throws Exception {
    Reparto r = new Reparto("Cardiologia","Cuore"); r.setId(1L);
    when(repartoService.findById(1L)).thenReturn(Optional.of(r));
    when(dottoreService.save(Mockito.any())).thenAnswer(inv -> inv.getArgument(0));

    mockMvc.perform(post("/medici")
        .param("nome","Mario")
        .param("cognome","Rossi")
        .param("email","mario.rossi@example.com")
        .param("telefono","3331234567")
        .param("specializzazione","Cardiologia")
        .param("repartoId","1"))
      .andExpect(status().is3xxRedirection());
      

    var cap = ArgumentCaptor.forClass(Dottore.class);
    Mockito.verify(dottoreService).save(cap.capture());
    assertThat(cap.getValue().getReparto().getId()).isEqualTo(1L);
  }
}
