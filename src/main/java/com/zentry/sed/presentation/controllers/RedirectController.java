package com.zentry.sed.presentation.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

  @GetMapping("/redirect")
  public String postLogin(Authentication auth) {
    if (auth == null) return "redirect:/login";

    Set<String> roles = auth.getAuthorities().stream()
        .map(a -> a.getAuthority()) // p.ej. ROLE_DOCENTE
        .collect(Collectors.toSet());

    if (roles.contains("ROLE_COMISION")) return "redirect:/comision/home";
    if (roles.contains("ROLE_DOCENTE"))  return "redirect:/docente/home";
    if (roles.contains("ROLE_ADMIN"))    return "redirect:/menu/admin";
    return "redirect:/alumno/home";
  }
}
