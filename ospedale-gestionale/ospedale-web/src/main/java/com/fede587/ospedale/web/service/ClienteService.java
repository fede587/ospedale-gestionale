package com.fede587.ospedale.web.service;

import com.fede587.ospedale.core.entity.Ruolo;
import com.fede587.ospedale.core.entity.Cliente;
import com.fede587.ospedale.core.repository.RuoloRepository;
import com.fede587.ospedale.core.repository.ClienteRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class ClienteService {
  private final ClienteRepository clienti;
  private final RuoloRepository ruoli;
  private final PasswordEncoder enc;

  public ClienteService(ClienteRepository clienti, RuoloRepository ruoli, PasswordEncoder enc){
    this.clienti = clienti; this.ruoli = ruoli; this.enc = enc;
  }

  public Cliente registra(String username, String password, boolean admin){
    Cliente cl = new Cliente(username, enc.encode(password));
    Ruolo rUser = ruoli.findByNome("ROLE_USER").orElseGet(() -> ruoli.save(new Ruolo("ROLE_USER")));
    cl.getRuoli().add(rUser);
    if(admin){
      Ruolo rAdmin = ruoli.findByNome("ROLE_ADMIN").orElseGet(() -> ruoli.save(new Ruolo("ROLE_ADMIN")));
      cl.getRuoli().add(rAdmin);
    }
    return clienti.save(cl);
  }
}
