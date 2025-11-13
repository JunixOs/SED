package com.zentry.sed.services.module_alumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.core.entities.module_core.MatriculaDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_core.ICursoRepository;
import com.zentry.sed.core.repositories.module_core.IMatriculaRepository;
import com.zentry.sed.core.repositories.module_core.ISeccionRepository;
import com.zentry.sed.presentation.models.requestDTO.module_alumnos.VerCursosPorSemestreRequestDTO;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.VerCursosPorSemestreResponseDTO;

@Service
public class EstudianteService {
    
    private final IEstudianteRepository estudianteRepository;
    private final IMatriculaRepository matriculaRepository;
    private final ISeccionRepository seccionRepository;
    private final ICursoRepository cursoRepository;

    public EstudianteService(
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

    public List<VerCursosPorSemestreResponseDTO> verCursosPorSemestre(VerCursosPorSemestreRequestDTO verCursosPorSemestreRequestDTO){

        EstudianteDomainEntity estudianteDomainEntity = estudianteRepository.findById(
            verCursosPorSemestreRequestDTO.getEstudianteId()
        ).orElse(null);

        List<MatriculaDomainEntity> listOfMatriculas = matriculaRepository.findByEstudianteIdAndEstudiante_SemestreAndEstudiante_Carrera(
            verCursosPorSemestreRequestDTO.getEstudianteId(), 
            estudianteDomainEntity.getSemestre(), 
            estudianteDomainEntity.getCarrera()
        );


        List<String> listOfCursosId = seccionRepository.findAllCursoIdById(
            listOfMatriculas.stream()
                .map(MatriculaDomainEntity::getSeccionId)
                .collect(Collectors.toList())
        );

        List<CursoDomainEntity> listOfCursos = cursoRepository.findAllById(listOfCursosId);

        List<VerCursosPorSemestreResponseDTO> responseDTO = new ArrayList<>();

        for(CursoDomainEntity cursoDomainEntity : listOfCursos){
            VerCursosPorSemestreResponseDTO verCursosPorSemestreResponseDTO = new VerCursosPorSemestreResponseDTO();

            verCursosPorSemestreResponseDTO.setIdCurso(cursoDomainEntity.getId());
            verCursosPorSemestreResponseDTO.setNombreCurso(cursoDomainEntity.getNombre());
            verCursosPorSemestreResponseDTO.setCodigoCurso(cursoDomainEntity.getCodigo());
            verCursosPorSemestreResponseDTO.setFacultadCurso(cursoDomainEntity.getFacultad());
            verCursosPorSemestreResponseDTO.setCreditosCurso(cursoDomainEntity.getCreditos());

            responseDTO.add(verCursosPorSemestreResponseDTO);
        }
        return responseDTO;
    }
}
