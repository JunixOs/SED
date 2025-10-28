package com.zentry.sed.core.repositories.module_roles;

import java.util.List;
import java.util.Optional;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;

public interface IRolRepository {
    public void save(RolDomainEntity rol);
    public List<RolDomainEntity> findAll();
    public Optional<RolDomainEntity> findById(String id);
}
