package com.fede587.ospedale.web.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class SecurityConfigTest {

    @Test
    void passwordEncoderTest() {
        SecurityConfig cfg = new SecurityConfig();
        PasswordEncoder pe = cfg.passwordEncoder();
        assertTrue(pe instanceof BCryptPasswordEncoder);
    }
}
