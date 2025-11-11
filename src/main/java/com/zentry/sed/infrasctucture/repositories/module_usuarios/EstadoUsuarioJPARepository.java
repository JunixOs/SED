package com.zentry.sed.infrasctucture.repositories.module_usuarios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.EstadoUsuarioEntity;

public interface EstadoUsuarioJPARepository extends JpaRepository<EstadoUsuarioEntity , UUID>{
    
}
