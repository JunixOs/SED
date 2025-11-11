package com.zentry.sed.core.repositories.module_core;

import java.util.List;
import java.util.Optional;

import com.zentry.sed.core.entities.module_core.SeccionDomainEntity;

public interface ISeccionRepository {
    public List<String> findAllCursoIdById(List<String> id);
    public Optional<SeccionDomainEntity> findById(String id);
    public void save(SeccionDomainEntity seccionDomainEntity);
    public void deleteById(String id);
}
