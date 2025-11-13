package com.zentry.sed.core.repositories.module_docentes;

import java.util.Optional;

import com.zentry.sed.core.entities.module_docentes.DocenteDomainEntity;

public interface IDocenteRepository {
    public void save(DocenteDomainEntity docenteDomainEntity);
    public void deleteById(String id);
    public Optional<DocenteDomainEntity> findById(String id);
}
