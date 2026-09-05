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
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/",
                        "/login",
                        "/register",
                        "/registrazione",
                        "/h2-console/**")
                .permitAll()
                .anyRequest()
                .authenticated());

        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**"));

        http.headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin()));

        http.formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll());

        http.logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll());

        return http.build();
    }
}
