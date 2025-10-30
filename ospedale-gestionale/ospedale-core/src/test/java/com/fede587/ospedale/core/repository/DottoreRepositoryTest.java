package com.fede587.ospedale.core.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fede587.ospedale.core.entity.Dottore;
import com.fede587.ospedale.core.entity.Reparto;

class DottoreRepositoryTest {


    @Autowired RepartoRepository repartoRepo;
    @Autowired DottoreRepository dottoreRepo;


    @Test
    void salva_e_trova_per_reparto_entity() {
  
        Reparto orto = new Reparto("Ortopedia", "Ossa");
        repartoRepo.save(orto);

        Dottore dr = new Dottore();
        dr.setNome("Luca");
        dr.setCognome("Bianchi");
        dr.setSpecializzazione("Ortopedia");
        dr.setReparto(orto);
        dottoreRepo.save(dr);

  
        List<Dottore> trovati = dottoreRepo.findByReparto(orto);

      
        assertThat(trovati).extracting(Dottore::getCognome).containsExactly("Bianchi");
    }
}
