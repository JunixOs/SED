package com.zentry.sed.presentation.models.mappers;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.presentation.models.dto.UsuarioDTO;

public class UsuarioMapper {
    
    public static UsuarioDomainEntity toDomainEntity(UsuarioDTO usuario){
        UsuarioDomainEntity usuarioDomainEntity = new UsuarioDomainEntity();

        usuarioDomainEntity.setNombre(usuario.getNombre());
        usuarioDomainEntity.setCorreo(usuario.getCorreo());
        usuarioDomainEntity.setRolId(usuario.getRolId());
        usuarioDomainEntity.setPasswordHash(usuario.getPasswordHash());
        usuarioDomainEntity.setEstado(usuario.getEstado());
        usuarioDomainEntity.setCreadoEn(usuario.getCreadoEn());
        usuarioDomainEntity.setActualizadoEn(usuario.getActualizadoEn());

        return usuarioDomainEntity;
    }

    public static UsuarioDTO toDTO(UsuarioDomainEntity usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setRolId(usuario.getRolId());
        usuarioDTO.setPasswordHash(usuario.getPasswordHash());
        usuarioDTO.setEstado(usuario.getEstado());
        usuarioDTO.setCreadoEn(usuario.getCreadoEn());
        usuarioDTO.setActualizadoEn(usuario.getActualizadoEn());

        return usuarioDTO;
    }
}
