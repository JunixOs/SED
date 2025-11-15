package com.zentry.sed.core.repositories.module_evaluacion;

import java.util.List;
import java.util.Optional;

import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;
import com.zentry.sed.core.entities.module_evaluacion.RespuestaDomainEntity;

public interface IRespuestaRepository {
    public Optional<RespuestaDomainEntity> findById(String id);
    public void save(RespuestaDomainEntity respuestaDomainEntity);
    public List<PreguntaDomainEntity> findAllPreguntasByEvaluacionId(String evaluacionId);
    public void saveAll(List<RespuestaDomainEntity> listRespuestaDomainEntities);
}
