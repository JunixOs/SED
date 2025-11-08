package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.PeriodoDomainEntitiy;
import com.zentry.sed.infrasctucture.database.entities.module_core.EstadoPeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;

public class PeriodoMapper {
    public static PeriodoEntity toEntity(
        PeriodoDomainEntitiy periodoDomainEntitiy , 
        EstadoPeriodoEntity estadoPeriodoEntity
    ){
        PeriodoEntity periodoEntity = new PeriodoEntity();

        periodoEntity.setAnio(periodoDomainEntitiy.getAnio());
        periodoEntity.setTermino(periodoDomainEntitiy.getTermino());
        periodoEntity.setFechaInicio(periodoDomainEntitiy.getFechaInicio());
        periodoEntity.setFechaFin(periodoDomainEntitiy.getFechaFin());
        periodoEntity.setEstadoPeriodo(estadoPeriodoEntity);

        return periodoEntity;
    }

    public static PeriodoDomainEntitiy toDomain(PeriodoEntity periodoEntity){
        PeriodoDomainEntitiy periodoDomainEntitiy = new PeriodoDomainEntitiy();

        periodoDomainEntitiy.setId(periodoEntity.getId().toString());
        periodoDomainEntitiy.setAnio(periodoEntity.getAnio());
        periodoDomainEntitiy.setTermino(periodoEntity.getTermino());
        periodoDomainEntitiy.setFechaInicio(periodoEntity.getFechaInicio());
        periodoDomainEntitiy.setFechaFin(periodoEntity.getFechaFin());
        periodoDomainEntitiy.setEstadoPeriodoDomainEntity(
            EstadoPeriodoMapper.toDomain(periodoEntity.getEstadoPeriodo())
        );

        return periodoDomainEntitiy;
    }
}
