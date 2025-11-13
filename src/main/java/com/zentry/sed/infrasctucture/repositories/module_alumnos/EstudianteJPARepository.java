package com.zentry.sed.infrasctucture.repositories.module_alumnos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;

public interface EstudianteJPARepository extends JpaRepository<EstudianteEntity , UUID>{
    public Optional<EstudianteEntity> findByUsuario_Id(UUID usuarioId);
}
