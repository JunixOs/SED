package com.zentry.sed.core.repositories.module_usuarios;

import java.util.List;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;

public interface IUsuarioRolRepository {
    public List<RolDomainEntity> findAllRolByUsuarioId(String usuarioId);
    public void save(String usuarioId , String rolId);
    public void deleteByUsuarioIdAndRolId(String usuarioId , String rolId);
}
