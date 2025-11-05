package com.fede587.ospedale.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/login", "/registrazione", "/h2-console/**").permitAll()
        .anyRequest().authenticated()
      )
      .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
      .headers(h -> h.frameOptions(f -> f.sameOrigin()))
      .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/", true).permitAll())
      .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll());
    return http.build();
  }
}
