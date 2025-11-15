package com.zentry.sed.presentation.models.mappers.module_alumnos;

import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;
import com.zentry.sed.core.entities.module_evaluacion.RespuestaDomainEntity;
import com.zentry.sed.presentation.models.requestDTO.module_alumnos.EvaluarDocenteRequestDTO;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.DataForEvaluarDocenteResponseDTO;

public class EvaluarDocenteMapper {
    public static DataForEvaluarDocenteResponseDTO domainToResponse(PreguntaDomainEntity preguntaDomainEntity){
        DataForEvaluarDocenteResponseDTO dataForEvaluarDocenteResponseDTO = new DataForEvaluarDocenteResponseDTO();

        dataForEvaluarDocenteResponseDTO.setPreguntaId(preguntaDomainEntity.getId());
        dataForEvaluarDocenteResponseDTO.setPreguntaModuloId(preguntaDomainEntity.getModuloId());
        
        dataForEvaluarDocenteResponseDTO.setPreguntaCriterioNombre(preguntaDomainEntity.getCriterioDomainEntity().getNombre());
        dataForEvaluarDocenteResponseDTO.setPreguntaCriterioDescripcion(preguntaDomainEntity.getCriterioDomainEntity().getDescripcion());

        dataForEvaluarDocenteResponseDTO.setPreguntaEnunciado(preguntaDomainEntity.getEnunciado());
        dataForEvaluarDocenteResponseDTO.setPreguntaOrden(preguntaDomainEntity.getOrden());
        dataForEvaluarDocenteResponseDTO.setPreguntapesoPregunta(preguntaDomainEntity.getPesoPregunta());

        return dataForEvaluarDocenteResponseDTO;
    }

    public static RespuestaDomainEntity requestToService(EvaluarDocenteRequestDTO evaluarDocenteRequestDTO){
        RespuestaDomainEntity respuestaDomainEntity = new RespuestaDomainEntity();

        respuestaDomainEntity.setEvaluacionId(evaluarDocenteRequestDTO.getEvaluacionId());
        respuestaDomainEntity.setPreguntaId(evaluarDocenteRequestDTO.getPreguntaId());
        respuestaDomainEntity.setValor(evaluarDocenteRequestDTO.getRespuestaValor());
        respuestaDomainEntity.setComentario(evaluarDocenteRequestDTO.getRespuestaComentario());

        return respuestaDomainEntity;
    }
}
