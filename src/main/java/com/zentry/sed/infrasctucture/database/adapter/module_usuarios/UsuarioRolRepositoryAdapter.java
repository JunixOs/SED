package com.zentry.sed.infrasctucture.database.adapter.module_usuarios;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioRolEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_roles.RolMapper;
import com.zentry.sed.infrasctucture.repositories.module_roles.RolJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioRolJPARepository;

@Repository
public class UsuarioRolRepositoryAdapter implements IUsuarioRolRepository{
    
    private final UsuarioRolJPARepository usuarioRolJPARepository;

    private final UsuarioJPARepository usuarioJPARepository;
    private final RolJPARepository rolJPARepository;

    public UsuarioRolRepositoryAdapter(
        UsuarioRolJPARepository usuarioRolJPARepository , 
        UsuarioJPARepository usuarioJPARepository,
        RolJPARepository rolJPARepository
    ){
        this.usuarioRolJPARepository = usuarioRolJPARepository;
        this.usuarioJPARepository = usuarioJPARepository;
        this.rolJPARepository = rolJPARepository;
    }

    public List<RolDomainEntity> findAllRolByUsuarioId(String usuarioId){
        return usuarioRolJPARepository.findRolByUsuarioId(
            UUID.fromString(usuarioId)
        ).stream()
        .map(RolMapper::toDomain)
        .collect(Collectors.toList());
    }

    public void save(String usuarioId , String rolId){
        UsuarioRolEntity usuarioRolEntity = new UsuarioRolEntity();

        usuarioRolEntity.setUsuario(
            usuarioJPARepository.findById(UUID.fromString(usuarioId)).orElse(null)
        );

        usuarioRolEntity.setRol(
            rolJPARepository.findById(UUID.fromString(rolId)).orElse(null)
        );

        usuarioRolJPARepository.save(usuarioRolEntity);
    }

    public void deleteByUsuarioIdAndRolId(String usuarioId , String rolId){
        usuarioRolJPARepository.deleteByUsuario_IdAndRol_Id(
            UUID.fromString(usuarioId),
            UUID.fromString(rolId)
        );
    }
}
