package com.zentry.sed.services.module_alumnos.usecases.command;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_evaluacion.RespuestaDomainEntity;
import com.zentry.sed.core.repositories.module_evaluacion.IRespuestaRepository;

@Component
public class EvaluarDocenteUseCase {
    
    private final IRespuestaRepository respuestaRepository;

    public EvaluarDocenteUseCase(
        IRespuestaRepository respuestaRepository
    ){
        this.respuestaRepository = respuestaRepository;
    }

    public String execute(List<RespuestaDomainEntity> listEvaluarDocenteServiceDTOs){
        
        respuestaRepository.saveAll(
            listEvaluarDocenteServiceDTOs
        );

        return "Evaluacion registrada con exito.";
    }
}
