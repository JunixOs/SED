package com.zentry.sed.core.repositories.module_core;

import java.util.List;

import com.zentry.sed.core.entities.module_core.CursoDomainEntity;

public interface ICursoRepository {
    public List<CursoDomainEntity> findAllById(List<String> ids);
    public void save(CursoDomainEntity cursoDomainEntity);
    public void deleteById(String id);
}
