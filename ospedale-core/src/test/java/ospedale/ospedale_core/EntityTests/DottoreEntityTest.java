package ospedale.ospedale_core.EntityTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;

class DottoreEntityTest {

    @Test
    void gettersSettersTestDottore() {
        Reparto reparto = new Reparto();
        reparto.setNome("Cardio");

        Dottore dr1 = new Dottore();
        dr1.setNome("Mario");
        dr1.setCognome("Rossi");
        dr1.setEmail("mario.rossi@example.com");
        dr1.setTelefono("0123");
        dr1.setSpecializzazione("Cardiologia");

        Dottore dr2 = new Dottore();
        dr2.setNome("Mario");
        dr2.setCognome("Rossi");
        dr2.setEmail("mario.rossi@example.com");
        dr2.setTelefono("0123");
        dr2.setSpecializzazione("Cardiologia");

     
        assertEquals("Mario", dr2.getNome());
        assertEquals("Rossi", dr2.getCognome());
        assertEquals("mario.rossi@example.com", dr2.getEmail());
        assertEquals("0123", dr2.getTelefono());
        assertEquals("Cardiologia", dr2.getSpecializzazione());

  
        assertTrue(dr1.equals(dr1));
        assertFalse(dr1.equals(null));
        assertFalse(dr1.equals(new Object()));

   
        dr1.equals(dr2);

      
        dr1.hashCode();
        assertNotNull(dr1.toString());
    }
}
