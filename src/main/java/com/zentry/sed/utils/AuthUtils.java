package com.zentry.sed.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

// Esto sirve para ver la informacion del usuario autenticado desde cualquier componente, servicio o controlador.

// Por ejemplo
// if (AuthUtils.isAuthenticated()) {
//     System.out.println("Usuario actual: " + AuthUtils.getCurrentUserEmail());
//     System.out.println("Rol: " + AuthUtils.getCurrentUserRole());
// }

public class AuthUtils {
    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getPrincipal());
    }

    public static String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null ? authentication.getName() : null; // El email es el "username"
    }

    public static String getCurrentUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getAuthorities() != null) {
            return authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}
