package com.zentry.sed.core.repositories.module_usuarios;

import java.util.List;
import java.util.Optional;

import com.zentry.sed.core.entities.module_usuarios.EstadoUsuarioDomainEntity;

public interface IEstadoUsuarioRepository {
    public void save(EstadoUsuarioDomainEntity estadoUsuarioDomainEntity);
    public void deleteById(String id);
    public Optional<EstadoUsuarioDomainEntity> findById(String id);
    public List<EstadoUsuarioDomainEntity> findAll();
}
