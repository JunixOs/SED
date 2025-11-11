package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.EstadoMatriculaDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.EstadoMatriculaEntity;

public class EstadoMatriculaMapper {
    public static EstadoMatriculaEntity toEntity(EstadoMatriculaDomainEntity estadoMatriculaDomainEntity){
        EstadoMatriculaEntity estadoMatriculaEntity = new EstadoMatriculaEntity();

        estadoMatriculaEntity.setCodigo(estadoMatriculaDomainEntity.getCodigo());
        estadoMatriculaEntity.setEtiqueta(estadoMatriculaDomainEntity.getEtiqueta());

        return estadoMatriculaEntity;
    }

    public static EstadoMatriculaDomainEntity toDomain(EstadoMatriculaEntity estadoMatriculaEntity){
        EstadoMatriculaDomainEntity estadoMatriculaDomainEntity = new EstadoMatriculaDomainEntity();

        estadoMatriculaDomainEntity.setId(estadoMatriculaEntity.getId().toString());
        estadoMatriculaDomainEntity.setCodigo(estadoMatriculaEntity.getCodigo());
        estadoMatriculaDomainEntity.setEtiqueta(estadoMatriculaEntity.getEtiqueta());

        return estadoMatriculaDomainEntity;
    }
}
