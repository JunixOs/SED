package com.zentry.sed.infrasctucture.database.mappers.module_comision;

import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;
import com.zentry.sed.core.entities.module_core.PeriodoDomainEntitiy;
import com.zentry.sed.infrasctucture.database.entities.module_comision.ComisionEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_core.PeriodoMapper;

public class ComisionMapper {
    public static ComisionEntity toEntity(ComisionDomainEntity comision , PeriodoDomainEntitiy periodo){
        ComisionEntity comisionEntity = new ComisionEntity();

        comisionEntity.setFacultad(comision.getFacultad());
        comisionEntity.setPeriodo(
            PeriodoMapper.toEntity(periodo)
        );
        comisionEntity.setRolMiembro(comision.getRolMiembro());
        
        return comisionEntity;
    }

    public static ComisionDomainEntity toDomain(ComisionEntity comision){
        ComisionDomainEntity comisionDomainEntity = new ComisionDomainEntity();

        comisionDomainEntity.setFacultad(comision.getFacultad());
        comisionDomainEntity.setPeriodoId(comision.getPeriodo().getId().toString());
        comisionDomainEntity.setRolMiembro(comision.getRolMiembro());

        return comisionDomainEntity;
    }
}
