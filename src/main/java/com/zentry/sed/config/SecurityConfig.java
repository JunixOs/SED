package com.zentry.sed.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.zentry.sed.services.JpaUserDetailsService;

@Configuration
public class SecurityConfig {

  @Autowired
  private JpaUserDetailsService jpaUserDetailsService;

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
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated()
      )

      .formLogin(form -> form
        .loginPage("/login")
        .usernameParameter("correo")
        .passwordParameter("password")
        // Fuerza ir SIEMPRE a /redirect al loguear (evita loop a /login guardado)
        //.defaultSuccessUrl("/redirect", true)
        .successHandler(customSuccessHandler())
        .failureHandler(customFailureHandler())
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

  @Bean
  public AuthenticationFailureHandler customFailureHandler() {
      return (request, response, exception) -> {
          String errorMessage = "Correo o contraseña incorrectos";
          request.getSession().setAttribute("errorMessage", errorMessage);
          response.sendRedirect("/login?error=true");
      };
  }

  @Bean
  public AuthenticationSuccessHandler customSuccessHandler() {
      return (request, response, authentication) -> {
          // Obtiene los roles del usuario
          Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

          String redirectURL = "/"; // valor por defecto

          if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
              redirectURL = "/admin/dashboard";
          } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_COMISION"))) {
              redirectURL = "/comision/dashboard";
          } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_DOCENTE"))) {
              redirectURL = "/docente/dashboard";
          } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ALUMNO"))) {
              redirectURL = "/alumno/dashboard";
          }

          response.sendRedirect(redirectURL);
      };
  }
}
