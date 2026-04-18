package com.zentry.sed.services.module_alumnos.usecases.query;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;
import com.zentry.sed.core.repositories.module_evaluacion.IRespuestaRepository;

@Component
public class SendDataForEvaluarDocenteUseCase {
    
    private final IRespuestaRepository respuestaRepository;

    public SendDataForEvaluarDocenteUseCase(IRespuestaRepository respuestaRepository){
        this.respuestaRepository = respuestaRepository;
    }

    public List<PreguntaDomainEntity> execute(String evaluacionId){
        return respuestaRepository.findAllPreguntasByEvaluacionId(evaluacionId);
    }
}
