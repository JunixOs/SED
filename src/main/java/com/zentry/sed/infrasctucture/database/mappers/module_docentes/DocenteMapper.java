package com.zentry.sed.infrasctucture.database.mappers.module_docentes;

import com.zentry.sed.core.entities.module_docentes.DocenteDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;

public class DocenteMapper {
    public static DocenteEntity toEntity(DocenteDomainEntity docenteDomainEntity){
        DocenteEntity docenteEntity = new DocenteEntity();

        docenteEntity.setDepartamento(docenteDomainEntity.getDepartamento());
        docenteEntity.setAntiguedad(docenteDomainEntity.getAntiguedad());
        docenteEntity.setGradoAcademico(docenteDomainEntity.getGradoAcademico());

        return docenteEntity;
    }

    public static DocenteDomainEntity toDomain(DocenteEntity docenteEntity){
        return DocenteDomainEntity.create(
            docenteEntity.getId().toString(), 
            docenteEntity.getDepartamento(), 
            docenteEntity.getAntiguedad(), 
            docenteEntity.getGradoAcademico()
        );
    }
}
