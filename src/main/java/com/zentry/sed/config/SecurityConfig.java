package com.zentry.sed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // opcional
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // permitir acceso a todas las rutas
            )
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)) // en vez de redirigir
            )
            .formLogin().disable() // deshabilita el login por formulario
            .httpBasic(); // opcional: si quieres permitir autenticación básica

        return http.build();
    }
}
