package com.zentry.sed.infrasctucture.database.mappers.module_comision;

import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_comision.ComisionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

public class ComisionMapper {
    public static ComisionEntity toEntity(
        ComisionDomainEntity comisionDomainEntity ,
        UsuarioEntity usuarioEntity , 
        PeriodoEntity periodoeEntity
    ){
        ComisionEntity comisionEntity = new ComisionEntity();

        comisionEntity.setUsuario(usuarioEntity);
        comisionEntity.setFacultad(comisionDomainEntity.getFacultad());
        comisionEntity.setPeriodo(periodoeEntity);
        comisionEntity.setRolMiembro(comisionDomainEntity.getRolMiembro());
        
        return comisionEntity;
    }

    public static ComisionDomainEntity toDomain(ComisionEntity comisionEntity){
        ComisionDomainEntity comisionDomainEntity = new ComisionDomainEntity();

        comisionDomainEntity.setId(comisionEntity.getId().toString());
        comisionDomainEntity.setUsuarioId(comisionEntity.getUsuario().getId().toString());
        comisionDomainEntity.setFacultad(comisionEntity.getFacultad());
        comisionDomainEntity.setPeriodoId(comisionEntity.getPeriodo().getId().toString());
        comisionDomainEntity.setRolMiembro(comisionEntity.getRolMiembro());

        return comisionDomainEntity;
    }
}
