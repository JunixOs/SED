package com.zentry.sed.infrasctucture.database.mappers.module_evaluacion;

import com.zentry.sed.core.entities.module_evaluacion.RespuestaDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.EvaluacionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.PreguntaEntity;
import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.RespuestaEntitiy;

public class RespuestaMapper {
    public static RespuestaEntitiy toEntitiy(
        RespuestaDomainEntity respuestaDomainEntity , 
        EvaluacionEntity evaluacionEntity , 
        PreguntaEntity preguntaEntity
    ){
        RespuestaEntitiy respuestaEntitiy = new RespuestaEntitiy();

        respuestaEntitiy.setEvaluacion(evaluacionEntity);
        respuestaEntitiy.setPregunta(preguntaEntity);
        respuestaEntitiy.setValor(respuestaDomainEntity.getValor());
        respuestaEntitiy.setComentario(respuestaDomainEntity.getComentario());

        return respuestaEntitiy;
    }

    public static RespuestaDomainEntity toDomain(RespuestaEntitiy respuestaEntitiy){
        RespuestaDomainEntity respuestaDomainEntity = new RespuestaDomainEntity();

        respuestaDomainEntity.setId(respuestaEntitiy.getId().toString());
        respuestaDomainEntity.setEvaluacionId(
            respuestaEntitiy.getEvaluacion().getId().toString()
        );
        respuestaDomainEntity.setPreguntaId(
            respuestaEntitiy.getPregunta().getId().toString()
        );
        respuestaDomainEntity.setValor(respuestaEntitiy.getValor());
        respuestaDomainEntity.setComentario(respuestaEntitiy.getComentario());

        return respuestaDomainEntity;
    }
}
