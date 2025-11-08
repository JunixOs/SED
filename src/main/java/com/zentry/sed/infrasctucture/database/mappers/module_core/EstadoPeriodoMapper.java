package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.EstadoPeriodoDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.EstadoPeriodoEntity;

public class EstadoPeriodoMapper {
    public static EstadoPeriodoEntity toEntity(EstadoPeriodoDomainEntity estadoPeriodoDomainEntity){
        EstadoPeriodoEntity estadoPeriodoEntity = new EstadoPeriodoEntity();

        estadoPeriodoEntity.setCodigo(estadoPeriodoDomainEntity.getCodigo());
        estadoPeriodoEntity.setEtiqueta(estadoPeriodoDomainEntity.getEtiqueta());

        return estadoPeriodoEntity;
    }

    public static EstadoPeriodoDomainEntity toDomain(EstadoPeriodoEntity estadoPeriodoEntity){
        EstadoPeriodoDomainEntity estadoPeriodoDomainEntity = new EstadoPeriodoDomainEntity();

        estadoPeriodoDomainEntity.setCodigo(estadoPeriodoEntity.getCodigo());
        estadoPeriodoDomainEntity.setEtiqueta(estadoPeriodoEntity.getEtiqueta());

        return estadoPeriodoDomainEntity;
    }
}
