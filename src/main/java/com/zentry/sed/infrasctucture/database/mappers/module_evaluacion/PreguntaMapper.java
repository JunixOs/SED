package com.zentry.sed.infrasctucture.database.mappers.module_evaluacion;

import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.CriterioEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.ModuloEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.PreguntaEntity;

public class PreguntaMapper {
    public static PreguntaEntity toEntity(
        PreguntaDomainEntity preguntaDomainEntity , 
        ModuloEntity moduloEntity , 
        CriterioEntity criterioEntity
    ){
        PreguntaEntity preguntaEntity = new PreguntaEntity();

        preguntaEntity.setModulo(moduloEntity);
        preguntaEntity.setCriterio(criterioEntity ); 
        preguntaEntity.setEnunciado(preguntaDomainEntity.getEnunciado());
        preguntaEntity.setOrden(preguntaDomainEntity.getOrden());
        preguntaEntity.setPesoPregunta(preguntaDomainEntity.getPesoPregunta());

        return preguntaEntity;
    }

    public static PreguntaDomainEntity toDomain(PreguntaEntity preguntaEntity){
        PreguntaDomainEntity preguntaDomainEntity = new PreguntaDomainEntity();
        
        preguntaDomainEntity.setId(preguntaEntity.getId().toString());
        preguntaDomainEntity.setModuloId(
            preguntaEntity.getModulo().getId().toString()
        );
        preguntaDomainEntity.setCriterioDomainEntity(
            CriterioMapper.toDomain(preguntaEntity.getCriterio())
        );
        preguntaDomainEntity.setEnunciado(preguntaEntity.getEnunciado());
        preguntaDomainEntity.setOrden(preguntaEntity.getOrden());
        preguntaDomainEntity.setPesoPregunta(preguntaEntity.getPesoPregunta());

        return preguntaDomainEntity;
    }
}
