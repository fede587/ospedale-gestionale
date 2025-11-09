package com.fede587.ospedale.web.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fede587.ospedale.core.entity.Cliente;
import com.fede587.ospedale.core.entity.Ruolo;
import com.fede587.ospedale.core.repository.ClienteRepository;

class CustomUserDetailsServiceTest {

    @Test
    void loadUser_ok_mapsAuthoritiesAndFlags() {
        ClienteRepository clienti = mock(ClienteRepository.class);
        CustomUserDetailsService custom = new CustomUserDetailsService(clienti);

        Cliente cl = mock(Cliente.class, Mockito.RETURNS_DEEP_STUBS);
        when(cl.getUsername()).thenReturn("mario");
        when(cl.getPassword()).thenReturn("ENC");
        when(cl.getRuoli()).thenReturn(Set.of(new Ruolo("ROLE_USER"), new Ruolo("ROLE_ADMIN")));
        when(clienti.findByUsername("mario")).thenReturn(Optional.of(cl));

        UserDetails ud = custom.loadUserByUsername("mario");

        assertEquals("mario", ud.getUsername());
        assertEquals("ENC", ud.getPassword());
        assertTrue(ud.isEnabled());
        assertTrue(ud.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
        assertTrue(ud.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
    }

    @Test
    void loadUser_notFound_throws() {
        ClienteRepository clienti = mock(ClienteRepository.class);
        CustomUserDetailsService custom = new CustomUserDetailsService(clienti);
        when(clienti.findByUsername("x")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> custom.loadUserByUsername("x"));
    }
}
