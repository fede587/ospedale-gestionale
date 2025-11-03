package com.fede587.ospedale.web.security;

import com.fede587.ospedale.core.entity.Cliente;
import com.fede587.ospedale.core.repository.ClienteRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final ClienteRepository clienti;
  public CustomUserDetailsService(ClienteRepository clienti){ this.clienti = clienti; }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Cliente c = clienti.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Cliente non trovato"));
    return new User(c.getUsername(), c.getPassword(), c.isAbilitato(), true, true, true,
      c.getRuoli().stream()
        .map(r -> new SimpleGrantedAuthority(r.getNome()))
        .collect(Collectors.toSet()));
  }
}
