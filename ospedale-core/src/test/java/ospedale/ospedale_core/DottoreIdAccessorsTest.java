package ospedale.ospedale_core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Dottore;

class DottoreIdAccessorsTest {

	
    @Test
    void getId_and_setId_coverBoth() {
        Dottore d = new Dottore();
        assertNull(d.getId());   
        d.setId(42L);           
        assertEquals(42L, d.getId());
    }
}
