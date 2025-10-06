package ospedale.ospedale_core;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ospedale.ospedale_core.entità.Dottore;
import ospedale.ospedale_core.entità.Reparto;

class RepartoMediciAccessorsTest {

    @Test
    void setMedici_and_getMedici_coverBoth() {
        Reparto reparto = new Reparto();
        Set<Dottore> dottori = new LinkedHashSet<>();
        dottori.add(new Dottore());

       
        reparto.setDottori(dottori);
    
        assertSame(dottori, reparto.getDottori());
    }
}
