package com.zentry.sed.core.repositories.module_core;

import java.util.Optional;

import com.zentry.sed.core.entities.module_core.PeriodoDomainEntitiy;

public interface IPeriodoRepository {
    public Optional<PeriodoDomainEntitiy> findById(String id);
}
