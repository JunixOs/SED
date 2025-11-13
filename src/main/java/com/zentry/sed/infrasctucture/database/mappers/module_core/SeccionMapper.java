package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.SeccionDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.CursoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.ModalidadSeccionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.SeccionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;

public class SeccionMapper {
    public static SeccionEntity toEntity(
        SeccionDomainEntity seccionDomainEntity , 
        CursoEntity cursoEntity ,
        PeriodoEntity periodoEntity , 
        ModalidadSeccionEntity modalidadSeccionEntity , 
        DocenteEntity docenteEntity
    ){
        SeccionEntity seccionEntity = new SeccionEntity();

        seccionEntity.setCurso(cursoEntity);
        seccionEntity.setPeriodo(periodoEntity);
        seccionEntity.setCodigoSeccion(seccionDomainEntity.getCodigoSeccion());
        seccionEntity.setModalidad(modalidadSeccionEntity);
        seccionEntity.setDocente(docenteEntity);

        return seccionEntity;
    }

    public static SeccionDomainEntity toDomain(SeccionEntity seccionEntity){
        SeccionDomainEntity seccionDomainEntity = new SeccionDomainEntity();

        seccionDomainEntity.setId(seccionEntity.getId().toString());
        seccionDomainEntity.setCursoDomainEntitiy(
            CursoMapper.toDomain(seccionEntity.getCurso())
        );
        seccionDomainEntity.setPeriodoId(
            seccionEntity.getPeriodo().getId().toString()
        );
        seccionDomainEntity.setCodigoSeccion(seccionEntity.getCodigoSeccion());
        seccionDomainEntity.setModalidadSeccionDomainEntity(
            ModalidadSeccionMapper.toDomain(seccionEntity.getModalidad())
        );
        seccionDomainEntity.setDocenteId(
            seccionEntity.getDocente().getId().toString()
        );

        return seccionDomainEntity;
    }
}
