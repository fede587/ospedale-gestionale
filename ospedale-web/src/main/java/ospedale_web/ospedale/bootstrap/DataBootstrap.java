package ospedale_web.ospedale.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ospedale.ospedale_core.entità.Cliente;
import ospedale.ospedale_core.entità.Reparto;
import ospedale.ospedale_core.entità.Ruolo;
import ospedale.ospedale_core.repository.ClienteRepository;
import ospedale.ospedale_core.repository.RepartoRepository;
import ospedale.ospedale_core.repository.RuoloRepository;

@Component
public class DataBootstrap implements CommandLineRunner {

  private final RuoloRepository ruoli;
  private final ClienteRepository clienti;
  private final RepartoRepository reparti;
  private final PasswordEncoder enc;

  public DataBootstrap(RuoloRepository ruoli, ClienteRepository clienti, RepartoRepository reparti, PasswordEncoder enc){
    this.ruoli = ruoli; this.clienti = clienti; this.reparti = reparti; this.enc = enc;
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
