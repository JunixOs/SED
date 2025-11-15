package com.zentry.sed.services.module_alumnos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_evaluacion.RespuestaDomainEntity;
import com.zentry.sed.services.module_alumnos.usecases.command.EvaluarDocenteUseCase;

@Service
public class EstudianteCommandService {
    
    private final EvaluarDocenteUseCase evaluarDocenteUseCase;

    public EstudianteCommandService(
        EvaluarDocenteUseCase evaluarDocenteUseCase
    ){
        this.evaluarDocenteUseCase = evaluarDocenteUseCase;
    }

    public String evaluarDocente(List<RespuestaDomainEntity> listEvaluarDocenteServiceDTOs){
        return evaluarDocenteUseCase.execute(listEvaluarDocenteServiceDTOs);
    }
}
