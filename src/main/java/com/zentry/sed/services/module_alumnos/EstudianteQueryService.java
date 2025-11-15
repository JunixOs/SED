package com.zentry.sed.services.module_alumnos;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;
import com.zentry.sed.services.module_alumnos.usecases.query.SendDataForEvaluarDocenteUseCase;
import com.zentry.sed.services.module_alumnos.usecases.query.SendDataForIndexPageUseCase;
import com.zentry.sed.services.module_alumnos.usecases.query.VerCursosPorSemestreUseCase;
import com.zentry.sed.services.module_alumnos.usecases.query.VerPerfilUseCase;

@Service
public class EstudianteQueryService {
    private final SendDataForIndexPageUseCase sendDataForIndexPageUseCase;
    private final VerCursosPorSemestreUseCase verCursosPorSemestreUseCase;
    private final VerPerfilUseCase verPerfilUseCase;
    private final SendDataForEvaluarDocenteUseCase sendDataForEvaluarDocenteUseCase;

    public EstudianteQueryService(
        SendDataForIndexPageUseCase sendDataForIndexPageUseCase , 
        VerCursosPorSemestreUseCase verCursosPorSemestreUseCase , 
        VerPerfilUseCase verPerfilUseCase , 
        SendDataForEvaluarDocenteUseCase sendDataForEvaluarDocenteUseCase
    ){
        this.sendDataForIndexPageUseCase = sendDataForIndexPageUseCase;
        this.verCursosPorSemestreUseCase = verCursosPorSemestreUseCase;
        this.verPerfilUseCase = verPerfilUseCase;
        this.sendDataForEvaluarDocenteUseCase = sendDataForEvaluarDocenteUseCase;
    }

    public Map<String , String> sendDataForIndexPage(String usuarioId) throws IOException {
        return sendDataForIndexPageUseCase.execute(usuarioId);
    }

    public List<CursoDomainEntity> verCursosPorSemestre(String usuarioId){
        return verCursosPorSemestreUseCase.execute(usuarioId);
    }

    public List<Object> verPerfil(String usuarioId){
        return verPerfilUseCase.execute(usuarioId);
    }

    public List<PreguntaDomainEntity> sendDataForEvaluarDocente(String evaluacionId){
        return sendDataForEvaluarDocenteUseCase.execute(evaluacionId);
    }
}
