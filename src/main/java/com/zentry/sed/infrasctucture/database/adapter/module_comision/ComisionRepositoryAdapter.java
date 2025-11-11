package com.zentry.sed.infrasctucture.database.adapter.module_comision;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;
import com.zentry.sed.core.repositories.module_comision.IComisionRepository;
import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;
import com.zentry.sed.infrasctucture.database.mappers.module_comision.ComisionMapper;
import com.zentry.sed.infrasctucture.repositories.module_comision.ComisionJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_core.PeriodoJPARepository;
import com.zentry.sed.infrasctucture.repositories.module_usuarios.UsuarioJPARepository;

@Repository
public class ComisionRepositoryAdapter implements IComisionRepository {
    
    private final ComisionJPARepository comisionJPARepository;

    private final UsuarioJPARepository usuarioJPARepository;
    private final PeriodoJPARepository periodoJPARepository;

    public ComisionRepositoryAdapter(
        ComisionJPARepository comisionJPARepository , 
        UsuarioJPARepository usuarioJPARepository , 
        PeriodoJPARepository periodoJPARepository
    ){
        this.comisionJPARepository = comisionJPARepository;
        this.usuarioJPARepository = usuarioJPARepository;
        this.periodoJPARepository = periodoJPARepository;
    }

    @Override
    public Optional<ComisionDomainEntity> findById(String id){
        return this.comisionJPARepository.findById(UUID.fromString(id)).map(ComisionMapper::toDomain);
    }

    public void save(ComisionDomainEntity comisionDomainEntity){
        
        UsuarioEntity usuarioEntity = usuarioJPARepository.findById(
            UUID.fromString(comisionDomainEntity.getUsuarioId())
        ).orElse(null);

        PeriodoEntity periodoEntity = periodoJPARepository.findById(
            UUID.fromString(comisionDomainEntity.getPeriodoId())
        ).orElse(null);
        
        comisionJPARepository.save(
            ComisionMapper.toEntity(
                comisionDomainEntity,
                usuarioEntity, 
                periodoEntity
            )
        );
    }

    public void deleteById(String id){
        comisionJPARepository.deleteById(UUID.fromString(id));
    }
}
