package com.zentry.sed.services.module_alumnos.usecases.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.core.entities.module_core.MatriculaDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_core.ICursoRepository;
import com.zentry.sed.core.repositories.module_core.IMatriculaRepository;
import com.zentry.sed.core.repositories.module_core.ISeccionRepository;

@Component
public class VerCursosPorSemestreUseCase {
    private final IEstudianteRepository estudianteRepository;
    private final IMatriculaRepository matriculaRepository;
    private final ISeccionRepository seccionRepository;
    private final ICursoRepository cursoRepository;

    public VerCursosPorSemestreUseCase(
        IEstudianteRepository estudianteRepository,
        IMatriculaRepository matriculaRepository,
        ISeccionRepository seccionRepository,
        ICursoRepository cursoRepository
    ){
        this.estudianteRepository = estudianteRepository;
        this.matriculaRepository = matriculaRepository;
        this.seccionRepository = seccionRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<CursoDomainEntity> execute(String usuarioId){

        EstudianteDomainEntity estudianteDomainEntity = estudianteRepository.findById(
            usuarioId
        ).orElse(null);

        List<MatriculaDomainEntity> listOfMatriculas = matriculaRepository.findByEstudianteIdAndEstudiante_SemestreAndEstudiante_Carrera(
            usuarioId, 
            estudianteDomainEntity.getSemestre(), 
            estudianteDomainEntity.getCarrera()
        );


        List<String> listOfCursosId = seccionRepository.findAllCursoIdById(
            listOfMatriculas.stream()
                .map(MatriculaDomainEntity::getSeccionId)
                .collect(Collectors.toList())
        );

        List<CursoDomainEntity> listOfCursos = cursoRepository.findAllById(listOfCursosId);

        return listOfCursos;
    }
}
