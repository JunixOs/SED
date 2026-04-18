package com.zentry.sed.infrasctucture.database.adapter.module_usuarios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_usuarios.EstadoUsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_usuarios.EstadoUsuarioMapper;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.EstadoUsuarioJPARepository;

@Repository
public class EstadoUsuarioRepositoryAdapter implements IEstadoUsuarioRepository {
    
    private final EstadoUsuarioJPARepository estadoUsuarioJPARepository;

    public EstadoUsuarioRepositoryAdapter(EstadoUsuarioJPARepository estadoUsuarioJPARepository){
        this.estadoUsuarioJPARepository = estadoUsuarioJPARepository;
    }

    public void save(EstadoUsuarioDomainEntity estadoUsuarioDomainEntity){
        estadoUsuarioJPARepository.save(
            EstadoUsuarioMapper.toEntity(estadoUsuarioDomainEntity)
        );
    }

    public void deleteById(String id){
        estadoUsuarioJPARepository.deleteById(UUID.fromString(id));
    }

    public Optional<EstadoUsuarioDomainEntity> findById(String id){
        return estadoUsuarioJPARepository.findById(UUID.fromString(id))
            .map(eu -> EstadoUsuarioMapper.toDomain(eu));
    }

    public List<EstadoUsuarioDomainEntity> findAll(){
        return estadoUsuarioJPARepository.findAll()
            .stream()
            .map(EstadoUsuarioMapper::toDomain)
            .collect(Collectors.toList());
    }
}
