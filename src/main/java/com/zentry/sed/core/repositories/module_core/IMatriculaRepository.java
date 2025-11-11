package com.zentry.sed.core.repositories.module_core;

import java.util.List;
import java.util.Optional;

import com.zentry.sed.core.entities.module_core.MatriculaDomainEntity;

public interface IMatriculaRepository {
    public List<MatriculaDomainEntity> findBySeccionId(String seccionId);
    public List<MatriculaDomainEntity> findByEstudianteId(String estudianteId);
    public List<MatriculaDomainEntity> findByEstudianteIdAndEstudiante_SemestreAndEstudiante_Carrera(String estudianteId , String semestre , String carrera);
    public List<MatriculaDomainEntity> findBySeccionIdAndEstudianteId(String seccionId , String estudianteId);
    public void save(MatriculaDomainEntity matriculaDomainEntity);
    public void deleteById(String id);
    public Optional<MatriculaDomainEntity> findById(String id);
}
