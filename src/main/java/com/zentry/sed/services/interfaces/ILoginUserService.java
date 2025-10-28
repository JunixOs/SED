package com.zentry.sed.services.interfaces;

import java.util.Optional;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;

public interface ILoginUserService {
    public Optional<UsuarioDomainEntity> login(String correo , String password);
}
