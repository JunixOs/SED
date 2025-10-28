package com.zentry.sed.infrasctucture.database.adapter.module_usuarios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_usuarios.UsuarioMapper;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioJPARepository;

import io.micrometer.common.lang.NonNull;

@Repository
public class UsuarioRepositoryAdapter implements IUsuarioRepository {
    
    private final UsuarioJPARepository usuarioJPARepository;

    public UsuarioRepositoryAdapter(UsuarioJPARepository usuarioJPARepository){
        this.usuarioJPARepository = usuarioJPARepository;
    }

    @Override
    @NonNull
    public List<UsuarioDomainEntity> findAll(){
        return usuarioJPARepository.findAll()
            .stream()
            .map(UsuarioMapper::toDomain)
            .collect(Collectors.toList());
    }
}
