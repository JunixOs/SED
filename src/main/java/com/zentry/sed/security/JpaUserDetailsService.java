package com.zentry.sed.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioJPARepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UsuarioJPARepository usuarios;

    public JpaUserDetailsService(UsuarioJPARepository usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        UsuarioEntity u = usuarios.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + correo));

        // === Null-check directo (sin Optional) ===
        String rolNombre = "alumno";
        if (u.getRol() != null && u.getRol().getNombre() != null && !u.getRol().getNombre().isBlank()) {
            rolNombre = u.getRol().getNombre();
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + rolNombre.toUpperCase());

        String passwordHash = u.getPasswordHash();
        if (passwordHash == null || passwordHash.isBlank()) {
            throw new UsernameNotFoundException("El usuario no tiene contraseña definida.");
        }

        return User.withUsername(u.getCorreo())
                .password(passwordHash)
                .authorities(List.of(authority))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
