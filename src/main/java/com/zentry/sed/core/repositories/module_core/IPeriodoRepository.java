package com.zentry.sed.core.repositories.module_core;

import java.util.Optional;

import com.zentry.sed.core.entities.module_core.PeriodoDomainEntity;

public interface IPeriodoRepository {
    public Optional<PeriodoDomainEntity> findById(String id);
}
