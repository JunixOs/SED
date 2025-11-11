package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.CursoEntity;

public class CursoMapper {
    public static CursoEntity toEntity(CursoDomainEntity cursoDomainEntity){
        CursoEntity cursoEntity = new CursoEntity();

        cursoEntity.setNombre(cursoDomainEntity.getNombre());
        cursoEntity.setCodigo(cursoDomainEntity.getCodigo());
        cursoEntity.setFacultad(cursoDomainEntity.getFacultad());
        cursoEntity.setCreditos(cursoDomainEntity.getCreditos());

        return cursoEntity;
    }

    public static CursoDomainEntity toDomain(CursoEntity cursoEntity){
        CursoDomainEntity cursoDomainEntity = new CursoDomainEntity();

        cursoDomainEntity.setNombre(cursoEntity.getNombre());
        cursoDomainEntity.setCodigo(cursoEntity.getCodigo());
        cursoDomainEntity.setFacultad(cursoEntity.getFacultad());
        cursoDomainEntity.setCreditos(cursoEntity.getCreditos());

        return cursoDomainEntity;
    }
}
