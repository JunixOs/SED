package com.zentry.sed.infrasctucture.repositories.module_core;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zentry.sed.infrasctucture.database.entities.module_core.MatriculaEntity;

public interface MatriculaJPARepository extends JpaRepository<MatriculaEntity , UUID>{

    public List<MatriculaEntity> findBySeccion_Id(UUID seccionId);

    public List<MatriculaEntity>  findByEstudiante_Id(UUID estudianteId);

    // Para traer todos los elementos de una entidad especifica (hacer un SELECT *) colocamos el nombre de la entidad que vamos a recibir
    // Las relaciones solo son con JOIN
    @Query("SELECT m FROM MatriculaEntity m JOIN m.estudiante e WHERE e.id = :estudianteId AND e.semestre = :semestre AND e.carrera = :carrera")
    public List<MatriculaEntity> findByEstudianteIdAndEstudiante_SemestreAndEstudiante_Carrera(
        @Param("estudianteId") UUID estudianteId , 
        @Param("semestre") String semestre ,
        @Param("carrera") String carrera
    );

    public List<MatriculaEntity> findBySeccion_IdAndEstudiante_Id(UUID seccionId , UUID estudianteId);
}
