package com.zentry.sed.infrasctucture.database.mappers.module_usuarios;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

public class UsuarioMapper {
    
    public static UsuarioEntity toEntity(
        UsuarioDomainEntity usuarioDomainEntity
    ){
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setNombreCompleto(usuarioDomainEntity.getNombreCompleto());
        usuarioEntity.setCorreo(usuarioDomainEntity.getCorreo());
        usuarioEntity.setPasswordHash(usuarioDomainEntity.getPasswordHash());
        usuarioEntity.setEstadoUsuarioEntity(
            EstadoUsuarioMapper.toEntity(usuarioDomainEntity.getEstadoUsuarioDomainEntity())
        );
        usuarioEntity.setCreadoEn(usuarioDomainEntity.getCreadoEn());
        usuarioEntity.setActualizadoEn(usuarioDomainEntity.getActualizadoEn());
        
        return usuarioEntity;
    }
    
    public static UsuarioDomainEntity toDomain(UsuarioEntity usuarioEntity){
        UsuarioDomainEntity usuarioDomainEntity = new UsuarioDomainEntity();
        
        usuarioDomainEntity.setNombreCompleto(usuarioEntity.getNombreCompleto());
        usuarioDomainEntity.setCorreo(usuarioEntity.getCorreo());
        usuarioDomainEntity.setPasswordHash(usuarioEntity.getPasswordHash());
        usuarioDomainEntity.setEstadoUsuarioDomainEntity(
            EstadoUsuarioMapper.toDomain(usuarioEntity.getEstadoUsuarioEntity())
        );
        usuarioDomainEntity.setCreadoEn(usuarioEntity.getCreadoEn());
        usuarioDomainEntity.setActualizadoEn(usuarioEntity.getActualizadoEn());
        
        return usuarioDomainEntity;
    }
}
