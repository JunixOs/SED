package com.zentry.sed.services.module_usuarios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.security.JwtUtil;

@Service
public class LoginUsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioRolRepository usuarioRolRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginUsuarioService(
        IUsuarioRepository usuarioRepository,
        IUsuarioRolRepository usuarioRolRepository,

        PasswordEncoder passwordEncoder,
        JwtUtil jwtUtil
    ){
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;

        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String login(String correo , String password){
        var usuario = usuarioRepository.findByCorreo(correo)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if(!passwordEncoder.matches(password , usuario.getPasswordHash())){
            throw new RuntimeException("Contrasñea incorrecta.");
        }

        List<String> roles = usuarioRolRepository.findAllRolByUsuarioId(usuario.getId())
            .stream()
            .map(r -> r.getNombre())
            .collect(Collectors.toList());

        return jwtUtil.generateToken(password, roles);
    }
}
