package com.fede587.ospedale.web.bootstrap;

import com.fede587.ospedale.core.entity.Reparto;
import com.fede587.ospedale.core.entity.Ruolo;
import com.fede587.ospedale.core.entity.Cliente;
import com.fede587.ospedale.core.repository.RepartoRepository;
import com.fede587.ospedale.core.repository.RuoloRepository;
import com.fede587.ospedale.core.repository.ClienteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements CommandLineRunner {

  private final RuoloRepository ruoli;
  private final ClienteRepository clienti;
  private final RepartoRepository reparti;
  private final PasswordEncoder enc;

  public DataBootstrap(RuoloRepository ruoli, ClienteRepository utenti, RepartoRepository reparti, PasswordEncoder enc){
    this.ruoli = ruoli; this.clienti = utenti; this.reparti = reparti; this.enc = enc;
  }

  @Override
  public void run(String... args) {
    Ruolo rUser = ruoli.findByNome("ROLE_USER").orElseGet(() -> ruoli.save(new Ruolo("ROLE_USER")));
    Ruolo rAdmin = ruoli.findByNome("ROLE_ADMIN").orElseGet(() -> ruoli.save(new Ruolo("ROLE_ADMIN")));

    clienti.findByUsername("admin").orElseGet(() -> {
      Cliente c = new Cliente("admin", enc.encode("password"));
      c.getRuoli().add(rUser); c.getRuoli().add(rAdmin);
      return clienti.save(c);
    });

    reparti.findByNomeIgnoreCase("Cardiologia").orElseGet(() -> reparti.save(new Reparto("Cardiologia","Cuore")));
    reparti.findByNomeIgnoreCase("Ortopedia").orElseGet(() -> reparti.save(new Reparto("Ortopedia","Ossa")));
  }
}
