package com.fede587.ospedale.core.entity;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RuoloGettersTest {

    @Test
    void getId_coversGetterEvenIfNull() {
        Ruolo r = new Ruolo("ROLE_USER");
      
        assertNull(r.getId());
    }
}
