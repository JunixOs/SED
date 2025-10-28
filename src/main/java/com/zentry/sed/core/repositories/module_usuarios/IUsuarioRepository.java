package com.zentry.sed.core.repositories.module_usuarios;

import java.util.List;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;

public interface IUsuarioRepository {
    public List<UsuarioDomainEntity> findAll();
}
