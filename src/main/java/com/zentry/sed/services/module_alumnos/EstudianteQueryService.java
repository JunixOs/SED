package com.zentry.sed.services.module_alumnos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.services.module_alumnos.usecases.query.VerCursosPorSemestreUseCase;
import com.zentry.sed.services.module_alumnos.usecases.query.VerPerfilUseCase;

@Service
public class EstudianteQueryService {
    private final VerCursosPorSemestreUseCase verCursosPorSemestreUseCase;
    private final VerPerfilUseCase verPerfilUseCase;

    public EstudianteQueryService(
        VerCursosPorSemestreUseCase verCursosPorSemestreUseCase , 
        VerPerfilUseCase verPerfilUseCase
    ){
        this.verCursosPorSemestreUseCase = verCursosPorSemestreUseCase;
        this.verPerfilUseCase = verPerfilUseCase;
    }

    public List<CursoDomainEntity> verCursosPorSemestre(String usuarioId){
        return verCursosPorSemestreUseCase.execute(usuarioId);
    }

    public List<Object> verPerfil(String usuarioId){
        return verPerfilUseCase.execute(usuarioId);
    }
}
