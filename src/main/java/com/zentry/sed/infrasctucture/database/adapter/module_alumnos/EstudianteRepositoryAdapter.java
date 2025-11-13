package com.zentry.sed.infrasctucture.database.adapter.module_alumnos;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_alumnos.EstudianteMapper;
import com.zentry.sed.infrasctucture.repositories.module_alumnos.EstudianteJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioJPARepository;

@Repository
public class EstudianteRepositoryAdapter implements IEstudianteRepository{
    
    private final EstudianteJPARepository estudianteJPARepository;

    private final UsuarioJPARepository usuarioJPARepository;

    public EstudianteRepositoryAdapter(
        EstudianteJPARepository estudianteJPARepository , 
        UsuarioJPARepository usuarioJPARepository
    ){
        this.estudianteJPARepository = estudianteJPARepository;
        this.usuarioJPARepository = usuarioJPARepository;
    }

    public void save(EstudianteDomainEntity estudianteDomainEntity){
        
        UsuarioEntity usuarioEntity = usuarioJPARepository.findById(
            UUID.fromString(estudianteDomainEntity.getUsuarioId())
        ).orElse(null);
        
        estudianteJPARepository.save(
            EstudianteMapper.toEntity(
                estudianteDomainEntity,
                usuarioEntity
            )
        );
    }

    public Optional<EstudianteDomainEntity> findById(String id){
        return estudianteJPARepository.findById(UUID.fromString(id))
            .map(e -> EstudianteMapper.toDomain(e));
    }  

    public Optional<EstudianteDomainEntity> findByUsuarioId(String usuarioId){
        return estudianteJPARepository.findByUsuario_Id(UUID.fromString(usuarioId))
            .map(e -> EstudianteMapper.toDomain(e));
    }
}
