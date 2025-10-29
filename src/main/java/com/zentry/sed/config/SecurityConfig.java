package com.zentry.sed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())

      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/login", "/error", "/favicon.ico",
                         "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
        .requestMatchers("/comision/**").hasRole("COMISION")
        .requestMatchers("/docente/**").hasRole("DOCENTE")
        .requestMatchers("/alumno/**").hasRole("ALUMNO")
        .requestMatchers("/menu/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
      )

      .formLogin(form -> form
        .loginPage("/login")
        .usernameParameter("correo")
        .passwordParameter("password")
        // Fuerza ir SIEMPRE a /redirect al loguear (evita loop a /login guardado)
        .defaultSuccessUrl("/redirect", true)
        .permitAll()
      )

      .rememberMe(Customizer.withDefaults())

      .logout(logout -> logout
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
        .logoutSuccessUrl("/login?logout")
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .deleteCookies("JSESSIONID")
      );

    return http.build();
  }
}
