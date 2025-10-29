package com.zentry.sed.core.repositories.module_comision;

import java.util.Optional;

import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;

public interface IComisionRepository {
    public Optional<ComisionDomainEntity> findById(String id);
}
