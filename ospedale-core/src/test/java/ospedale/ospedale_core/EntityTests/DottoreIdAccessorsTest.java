package ospedale.ospedale_core.EntityTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Dottore;

class DottoreIdAccessorsTest {
	
    @Test
    void getId_and_setId_coverBoth() {
        Dottore dr = new Dottore();
        assertNull(dr.getId());   
        dr.setId(42L);           
        assertEquals(42L, dr.getId());
    }
}
