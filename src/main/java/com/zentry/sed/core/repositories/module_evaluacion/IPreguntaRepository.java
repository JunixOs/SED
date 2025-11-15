package com.zentry.sed.core.repositories.module_evaluacion;

import java.util.Optional;

import com.zentry.sed.core.entities.module_evaluacion.PreguntaDomainEntity;

public interface IPreguntaRepository {
    public Optional<PreguntaDomainEntity> findById(String id);
    public void save(PreguntaDomainEntity preguntaEntity);
}
