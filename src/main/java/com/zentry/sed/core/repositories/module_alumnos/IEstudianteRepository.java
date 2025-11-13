package com.zentry.sed.core.repositories.module_alumnos;

import java.util.Optional;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;

public interface IEstudianteRepository {
    public void save(EstudianteDomainEntity estudianteDomainEntity);
    public Optional<EstudianteDomainEntity> findById(String id);
    public Optional<EstudianteDomainEntity> findByUsuarioId(String usuarioId);
}
