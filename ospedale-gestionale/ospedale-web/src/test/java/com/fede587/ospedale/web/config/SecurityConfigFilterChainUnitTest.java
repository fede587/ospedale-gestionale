package com.fede587.ospedale.web.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

class SecurityConfigFilterChainUnitTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	void filterChain_allLambdas_areExecuted() throws Exception {
		SecurityConfig cfg = new SecurityConfig();

		HttpSecurity http = mock(HttpSecurity.class);

		AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry = mock(
				AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry.class,
				Mockito.RETURNS_DEEP_STUBS);
		FormLoginConfigurer<HttpSecurity> form = mock(FormLoginConfigurer.class, Mockito.RETURNS_DEEP_STUBS);
		LogoutConfigurer<HttpSecurity> logout = mock(LogoutConfigurer.class, Mockito.RETURNS_DEEP_STUBS);
		mock(HeadersConfigurer.FrameOptionsConfig.class, Mockito.RETURNS_DEEP_STUBS);

		when(http.authorizeHttpRequests(any(Customizer.class))).thenAnswer(inv -> {
			Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> c = (Customizer) inv
					.getArgument(0);
			c.customize(registry);
			return http;
		});

		when(http.formLogin(any(Customizer.class))).thenAnswer(inv -> {
			Customizer<FormLoginConfigurer<HttpSecurity>> c = (Customizer) inv.getArgument(0);
			c.customize(form);
			return http;
		});

		when(http.logout(any(Customizer.class))).thenAnswer(inv -> {
			Customizer<LogoutConfigurer<HttpSecurity>> c = (Customizer) inv.getArgument(0);
			c.customize(logout);
			return http;
		});

		DefaultSecurityFilterChain chain = mock(DefaultSecurityFilterChain.class);
		when(http.build()).thenReturn(chain);

		SecurityFilterChain result = cfg.filterChain(http);

		assertNotNull(result);
		verify(http, atLeastOnce()).authorizeHttpRequests(any(Customizer.class));
		verify(http, atLeastOnce()).formLogin(any(Customizer.class));
		verify(http, atLeastOnce()).logout(any(Customizer.class));
		verify(http).build();
	}
}
