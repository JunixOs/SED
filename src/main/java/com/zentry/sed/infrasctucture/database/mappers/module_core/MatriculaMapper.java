package com.zentry.sed.infrasctucture.database.mappers.module_core;

import com.zentry.sed.core.entities.module_core.MatriculaDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.EstadoMatriculaEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.MatriculaEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.SeccionEntity;

public class MatriculaMapper {
    public static MatriculaEntity toEntity(
        MatriculaDomainEntity matriculaDomainEntity , 
        EstadoMatriculaEntity estadoMatriculaEntity , 
        SeccionEntity seccionEntity , 
        EstudianteEntity estudianteEntity
    ){
        MatriculaEntity matriculaEntity = new MatriculaEntity();

        matriculaEntity.setFechaMatricula(matriculaDomainEntity.getFechaMatricula());
        matriculaEntity.setEstadoMatricula(estadoMatriculaEntity);
        matriculaEntity.setSeccion(seccionEntity);
        matriculaEntity.setEstudiante(estudianteEntity);

        return matriculaEntity;
    }

    public static MatriculaDomainEntity toDomain(MatriculaEntity matriculaEntity){
        MatriculaDomainEntity matriculaDomainEntity = new MatriculaDomainEntity();

        matriculaDomainEntity.setFechaMatricula(matriculaEntity.getFechaMatricula());
        matriculaDomainEntity.setEstadoMatriculaDomainEntity(
            EstadoMatriculaMapper.toDomain(matriculaEntity.getEstadoMatricula())
        );

        matriculaDomainEntity.setSeccionId(
            matriculaEntity.getSeccion().getId().toString()
        );
        matriculaDomainEntity.setEstudianteId(
            matriculaEntity.getEstudiante().getId().toString()
        );

        return matriculaDomainEntity;
    }
}
