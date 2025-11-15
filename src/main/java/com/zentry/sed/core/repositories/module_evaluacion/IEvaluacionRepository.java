package com.zentry.sed.core.repositories.module_evaluacion;

import java.util.Optional;

import com.zentry.sed.core.entities.module_evaluacion.EvaluacionDomainEntity;

public interface IEvaluacionRepository {
    public Optional<EvaluacionDomainEntity> findById(String id);
    public void save(EvaluacionDomainEntity evaluacionDomainEntity);
}
