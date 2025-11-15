package com.zentry.sed.infrasctucture.database.adapter.module_usuarios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.EstadoUsuarioEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_usuarios.UsuarioMapper;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.EstadoUsuarioJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioJPARepository;

import io.micrometer.common.lang.NonNull;

@Repository
public class UsuarioRepositoryAdapter implements IUsuarioRepository {
    
    private final UsuarioJPARepository usuarioJPARepository;
    private final EstadoUsuarioJPARepository estadoUsuarioJPARepository;

    public UsuarioRepositoryAdapter(
        UsuarioJPARepository usuarioJPARepository , 
        EstadoUsuarioJPARepository estadoUsuarioJPARepository
    ){
        this.usuarioJPARepository = usuarioJPARepository;
        this.estadoUsuarioJPARepository = estadoUsuarioJPARepository;
    }

    @Override
    @NonNull
    public List<UsuarioDomainEntity> findAll(){
        return usuarioJPARepository.findAll()
            .stream()
            .map(UsuarioMapper::toDomain)
            .collect(Collectors.toList());
    }

    public Optional<UsuarioDomainEntity> findByCorreo(String correo){
        return usuarioJPARepository.findByCorreo(correo).map(u -> UsuarioMapper.toDomain(u));
    }

    public Optional<UsuarioDomainEntity> findById(String id){
        return usuarioJPARepository.findById(UUID.fromString(id))
            .map(u -> UsuarioMapper.toDomain(u));
    }

    public void save(UsuarioDomainEntity usuarioDomainEntity){

        EstadoUsuarioEntity estadoUsuarioEntity = estadoUsuarioJPARepository.findById(
            UUID.fromString(usuarioDomainEntity.getEstadoUsuarioDomainEntity().getId())
        ).orElse(null);

        usuarioJPARepository.save(
            UsuarioMapper.toEntity(
                usuarioDomainEntity , 
                estadoUsuarioEntity
            )
        );
    }
}
