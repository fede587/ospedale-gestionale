package ospedale_web.ospedale.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ospedale.ospedale_core.entità.Cliente;
import ospedale.ospedale_core.entità.Ruolo;
import ospedale.ospedale_core.repository.ClienteRepository;
import ospedale.ospedale_core.repository.RuoloRepository;

@Service @Transactional
public class ClienteService {
  private final ClienteRepository clienti;
  private final RuoloRepository ruoli;
  private final PasswordEncoder enc;

  public ClienteService(ClienteRepository Clienti, RuoloRepository ruoli, PasswordEncoder enc){
    this.clienti = Clienti; this.ruoli = ruoli; this.enc = enc;
  }

  public Cliente registra(String username, String password, boolean admin){
    Cliente c = new Cliente(username, enc.encode(password));
    Ruolo rUser = ruoli.findByNome("ROLE_USER").orElseGet(() -> ruoli.save(new Ruolo("ROLE_USER")));
    c.getRuoli().add(rUser);
    if(admin){
      Ruolo rAdmin = ruoli.findByNome("ROLE_ADMIN").orElseGet(() -> ruoli.save(new Ruolo("ROLE_ADMIN")));
      c.getRuoli().add(rAdmin);
    }
    return clienti.save(c);
  }
}
