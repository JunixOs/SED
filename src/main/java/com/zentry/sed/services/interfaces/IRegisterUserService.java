package com.zentry.sed.services.interfaces;

import java.util.List;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;

public interface IRegisterUserService {
    public List<RolDomainEntity> findAllRoles();
    public void register();
}
