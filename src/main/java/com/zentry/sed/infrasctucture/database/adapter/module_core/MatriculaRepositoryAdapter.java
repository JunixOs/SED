package com.zentry.sed.infrasctucture.database.adapter.module_core;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_core.MatriculaDomainEntity;
import com.zentry.sed.core.repositories.module_core.IMatriculaRepository;
import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.EstadoMatriculaEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.SeccionEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_core.MatriculaMapper;
import com.zentry.sed.infrasctucture.repositories.module_alumnos.EstudianteJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.EstadoMatriculaJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.MatriculaJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.SeccionJPARepository;

@Repository
public class MatriculaRepositoryAdapter implements IMatriculaRepository {

    private final MatriculaJPARepository matriculaJPARepository;

    private final EstadoMatriculaJPARepository estadoMatriculaJPARepository;
    private final SeccionJPARepository seccionJPARepository;
    private final EstudianteJPARepository estudianteJPARepository;

    public MatriculaRepositoryAdapter(
        MatriculaJPARepository matriculaJPARepository , 
        EstadoMatriculaJPARepository estadoMatriculaJPARepository,
        SeccionJPARepository seccionJPARepository , 
        EstudianteJPARepository estudianteJPARepository
    ){
        this.matriculaJPARepository = matriculaJPARepository;
        this.estadoMatriculaJPARepository = estadoMatriculaJPARepository;
        this.seccionJPARepository = seccionJPARepository;
        this.estudianteJPARepository = estudianteJPARepository;
    }

    public List<MatriculaDomainEntity> findBySeccionId(String seccionId){
        return matriculaJPARepository.findBySeccion_Id(UUID.fromString(seccionId))
            .stream()
            .map(MatriculaMapper::toDomain)
            .collect(Collectors.toList());
    }

    public List<MatriculaDomainEntity> findByEstudianteId(String estudianteId){
        return matriculaJPARepository.findByEstudiante_Id(UUID.fromString(estudianteId))
            .stream()
            .map(MatriculaMapper::toDomain)
            .collect(Collectors.toList());
    }

    public List<MatriculaDomainEntity> findByEstudianteIdAndEstudiante_SemestreAndEstudiante_Carrera(String estudianteId , String semestre , String carrera){
        return matriculaJPARepository.findByEstudianteIdAndEstudiante_SemestreAndEstudiante_Carrera(UUID.fromString(estudianteId), semestre, carrera)
            .stream()
            .map(MatriculaMapper::toDomain)
            .collect(Collectors.toList());
    }

    public List<MatriculaDomainEntity> findBySeccionIdAndEstudianteId(String seccionId , String estudianteId){
        return matriculaJPARepository.findBySeccion_IdAndEstudiante_Id(UUID.fromString(seccionId) , UUID.fromString(estudianteId))
            .stream()
            .map(MatriculaMapper::toDomain)
            .collect(Collectors.toList());
    }

    public void save(MatriculaDomainEntity matriculaDomainEntity){
        
        EstadoMatriculaEntity estadoMatriculaEntity = estadoMatriculaJPARepository.findById(
            UUID.fromString(matriculaDomainEntity.getEstadoMatriculaDomainEntity().getId())
        ).orElse(null);

        SeccionEntity seccionEntity = seccionJPARepository.findById(
            UUID.fromString(matriculaDomainEntity.getSeccionId())
        ).orElse(null);

        EstudianteEntity estudianteEntity = estudianteJPARepository.findById(
            UUID.fromString(matriculaDomainEntity.getEstudianteId())
        ).orElse(null);

        
        matriculaJPARepository.save(
            MatriculaMapper.toEntity(
                matriculaDomainEntity,
                estadoMatriculaEntity,
                seccionEntity, 
                estudianteEntity
            )
        );
    }

    public void deleteById(String id){
        matriculaJPARepository.deleteById(UUID.fromString(id));
    }

    public Optional<MatriculaDomainEntity> findById(String id){
        return matriculaJPARepository.findById(UUID.fromString(id))
            .map(m -> MatriculaMapper.toDomain(m));
    }
}
