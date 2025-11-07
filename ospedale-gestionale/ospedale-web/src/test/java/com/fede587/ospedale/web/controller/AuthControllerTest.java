package com.fede587.ospedale.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    private MockMvc mvc;

    @BeforeEach
    void setup() throws Exception {
       
        Constructor<?> ctor = Arrays.stream(AuthController.class.getDeclaredConstructors())
                                    .findFirst()
                                    .orElseThrow(() -> new IllegalStateException("Nessun costruttore trovato per AuthController"));

       
        Object[] args = Arrays.stream(ctor.getParameterTypes())
                              .map(Mockito::mock)
                              .toArray();

        
        AuthController controller = (AuthController) ctor.newInstance(args);

        
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void login_ok() throws Exception {
        mvc.perform(get("/login"))
           .andExpect(status().isOk());
    }
}
