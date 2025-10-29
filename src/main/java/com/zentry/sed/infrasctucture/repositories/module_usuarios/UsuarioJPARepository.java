package com.zentry.sed.infrasctucture.repositories.module_usuarios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

public interface UsuarioJPARepository extends JpaRepository<UsuarioEntity , UUID> {
    public List<UsuarioEntity> findAll();
    public Optional<UsuarioEntity> findByCorreo(String correo);
}
