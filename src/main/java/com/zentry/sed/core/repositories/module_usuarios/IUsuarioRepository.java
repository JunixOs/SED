package com.zentry.sed.core.repositories.module_usuarios;

import java.util.List;
import java.util.Optional;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;

public interface IUsuarioRepository {
    public List<UsuarioDomainEntity> findAll();
    public Optional<UsuarioDomainEntity> findByCorreo(String correo);
    public Optional<UsuarioDomainEntity> findById(String id);
    public void save(UsuarioDomainEntity usuarioDomainEntity);
}
