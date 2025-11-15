package com.zentry.sed.infrasctucture.database.mappers.module_evaluacion;

import com.zentry.sed.core.entities.module_evaluacion.CriterioDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.CriterioEntity;

public class CriterioMapper {
    public static CriterioEntity toEntity(CriterioDomainEntity criterioDomainEntity){
        CriterioEntity criterioEntity = new CriterioEntity();

        criterioEntity.setNombre(criterioDomainEntity.getNombre());
        criterioEntity.setDescripcion(criterioDomainEntity.getDescripcion());

        return criterioEntity;
    }

    public static CriterioDomainEntity toDomain(CriterioEntity criterioEntity){
        CriterioDomainEntity criterioDomainEntity = new CriterioDomainEntity();

        criterioDomainEntity.setId(criterioEntity.getId().toString());
        criterioDomainEntity.setNombre(criterioEntity.getNombre());
        criterioDomainEntity.setDescripcion(criterioEntity.getDescripcion());

        return criterioDomainEntity;
    }
}
