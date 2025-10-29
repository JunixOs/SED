package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.PeriodoDomainEntitiy;
import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;

public class PeriodoMapper {
    public static PeriodoEntity toEntity(PeriodoDomainEntitiy periodo){
        PeriodoEntity periodoEntity = new PeriodoEntity();

        periodoEntity.setAnio(periodo.getAnio());
        periodoEntity.setTerm(periodo.getTerm());
        periodoEntity.setFechaInicio(periodo.getFechaInicio());
        periodo.setFechaFin(periodo.getFechaFin());

        return periodoEntity;
    }

    public static PeriodoDomainEntitiy toDomain(PeriodoEntity periodo){
        PeriodoDomainEntitiy periodoDomainEntitiy = new PeriodoDomainEntitiy();

        periodoDomainEntitiy.setAnio(periodo.getAnio());
        periodoDomainEntitiy.setTerm(periodo.getTerm());
        periodoDomainEntitiy.setFechaInicio(periodo.getFechaInicio());
        periodoDomainEntitiy.setFechaFin(periodo.getFechaFin());

        return periodoDomainEntitiy;
    }
}
