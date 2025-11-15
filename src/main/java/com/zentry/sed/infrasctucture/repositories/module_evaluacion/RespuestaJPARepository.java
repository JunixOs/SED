package com.zentry.sed.infrasctucture.repositories.module_evaluacion;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.PreguntaEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.RespuestaEntitiy;

public interface RespuestaJPARepository extends JpaRepository<RespuestaEntitiy , UUID>{
    @Query(
        """
            SELECT p FROM RespuestaEntity r 
            JOIN r.pregunta p 
            WHERE r.evaluacion.id = :evaluacionId
        """
    )
    public List<PreguntaEntity> findAllPreguntasByEvaluacion_Id(@Param("evaluacionId") UUID evaluacionId);
}
