package com.zentry.sed.infrasctucture.database.mappers.module_alumnos;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

public class EstudianteMapper {
    public static EstudianteEntity toEntity(
        EstudianteDomainEntity estudianteDomainEntity , 
        UsuarioEntity usuarioEntity
    ){
        EstudianteEntity estudianteEntity = new EstudianteEntity();

        estudianteEntity.setUsuario(usuarioEntity);
        estudianteEntity.setSemestre(estudianteDomainEntity.getSemestre());
        estudianteEntity.setCarrera(estudianteDomainEntity.getCarrera());
        estudianteEntity.setCodigoEstudiante(estudianteDomainEntity.getCodigoEstudiante());

        return estudianteEntity;
    }

    public static EstudianteDomainEntity toDomain(EstudianteEntity estudianteEntity){
        EstudianteDomainEntity estudianteDomainEntity = new EstudianteDomainEntity();

        estudianteDomainEntity.setId(estudianteEntity.getId().toString());
        estudianteDomainEntity.setUsuarioId(
            estudianteEntity.getUsuario().getId().toString()
        );
        estudianteDomainEntity.setSemestre(estudianteEntity.getSemestre());
        estudianteDomainEntity.setCarrera(estudianteEntity.getCarrera());
        estudianteDomainEntity.setCodigoEstudiante(estudianteEntity.getCodigoEstudiante());;

        return estudianteDomainEntity;
    }
}
