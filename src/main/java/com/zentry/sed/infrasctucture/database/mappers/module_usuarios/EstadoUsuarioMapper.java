package com.zentry.sed.infrasctucture.database.mappers.module_usuarios;

import com.zentry.sed.core.entities.module_usuarios.EstadoUsuarioDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.EstadoUsuarioEntity;

public class EstadoUsuarioMapper {
    public static EstadoUsuarioEntity toEntity(EstadoUsuarioDomainEntity estadoUsuarioDomainEntity){
        EstadoUsuarioEntity estadoUsuarioEntity = new EstadoUsuarioEntity();

        estadoUsuarioEntity.setCodigo(estadoUsuarioDomainEntity.getCodigo());
        estadoUsuarioEntity.setEtiqueta(estadoUsuarioDomainEntity.getEtiqueta());

        return estadoUsuarioEntity;
    }

    public static EstadoUsuarioDomainEntity toDomain(EstadoUsuarioEntity estadoUsuarioEntity){
        EstadoUsuarioDomainEntity estadoUsuarioDomainEntity = new EstadoUsuarioDomainEntity();

        estadoUsuarioDomainEntity.setCodigo(estadoUsuarioEntity.getCodigo());
        estadoUsuarioDomainEntity.setEtiqueta(estadoUsuarioEntity.getEtiqueta());

        return estadoUsuarioDomainEntity;
    }
}