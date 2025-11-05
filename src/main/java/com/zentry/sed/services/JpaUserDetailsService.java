package com.zentry.sed.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.security.CustomUserDetails;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;
    private final IRolRepository rolRepository;

    public JpaUserDetailsService(IUsuarioRepository usuarioRepository , IRolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        UsuarioDomainEntity userFounded = usuarioRepository.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("No se encontro al usuario"));

        Optional<RolDomainEntity> rolFounded = rolRepository.findById(userFounded.getRolId());

        // === Null-check directo (sin Optional) ===
        String rolNombre = "alumno";
        if (rolFounded.isPresent() && rolFounded.get().getNombre() != null && !rolFounded.get().getNombre().isBlank()) {
            rolNombre = rolFounded.get().getNombre();
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + rolNombre.toUpperCase());

        String passwordHash = userFounded.getPasswordHash();
        if (passwordHash == null || passwordHash.isBlank()) {
            throw new UsernameNotFoundException("El usuario no tiene contraseña definida.");
        }

        return User.withUsername(userFounded.getCorreo())
                .password(passwordHash)
                .authorities(List.of(authority))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
