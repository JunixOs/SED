package com.zentry.sed.infrasctucture.database.mappers.module_roles;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

public class RolMapper {
    
    public static RolEntity toEntity(RolDomainEntity rol){
        RolEntity rolEntity = new RolEntity();

        rolEntity.setNombre(rol.getNombre());

        return rolEntity;
    }

    public static RolDomainEntity toDomain(RolEntity rol) {
        RolDomainEntity rolDomainEntity = new RolDomainEntity();

        rolDomainEntity.setNombre(rol.getNombre());
        
        return rolDomainEntity;
    }
}
