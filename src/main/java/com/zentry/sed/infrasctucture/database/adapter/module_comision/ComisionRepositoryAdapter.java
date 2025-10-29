package com.zentry.sed.infrasctucture.database.adapter.module_comision;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;
import com.zentry.sed.core.repositories.module_comision.IComisionRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_comision.ComisionMapper;
import com.zentry.sed.infrasctucture.repositories.module_comision.ComisionJPARepository;

@Repository
public class ComisionRepositoryAdapter implements IComisionRepository {
    
    private final ComisionJPARepository comisionJPARepository;

    public ComisionRepositoryAdapter(ComisionJPARepository comisionJPARepository){
        this.comisionJPARepository = comisionJPARepository;
    }

    @Override
    public Optional<ComisionDomainEntity> findById(String id){
        return this.comisionJPARepository.findById(UUID.fromString(id)).map(ComisionMapper::toDomain);
    }
}
