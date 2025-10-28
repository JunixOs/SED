package com.zentry.sed.infrasctucture.database.mappers.module_usuarios;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_roles.RolMapper;

public class UsuarioMapper {
    
    public static UsuarioEntity toEntity(UsuarioDomainEntity usuario , RolDomainEntity rol){
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setCorreo(usuario.getCorreo());
        usuarioEntity.setRol(RolMapper.toEntity(rol));
        usuarioEntity.setPasswordHash(usuario.getPasswordHash());
        usuarioEntity.setEstado(usuario.getEstado());
        usuarioEntity.setCreadoEn(usuario.getCreadoEn());
        usuarioEntity.setActualizadoEn(usuario.getActualizadoEn());
        
        return usuarioEntity;
    }
    
    public static UsuarioDomainEntity toDomain(UsuarioEntity usuario){
        UsuarioDomainEntity usuarioDomainEntity = new UsuarioDomainEntity();
        
        usuarioDomainEntity.setNombre(usuario.getNombre());
        usuarioDomainEntity.setCorreo(usuario.getCorreo());
        usuarioDomainEntity.setRolId(usuario.getRol().getId().toString());
        usuarioDomainEntity.setPasswordHash(usuario.getPasswordHash());
        usuarioDomainEntity.setEstado(usuario.getEstado());
        usuarioDomainEntity.setCreadoEn(usuario.getCreadoEn());
        usuarioDomainEntity.setActualizadoEn(usuario.getActualizadoEn());
        
        return usuarioDomainEntity;
    }
}
