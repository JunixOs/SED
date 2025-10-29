package com.zentry.sed.infrasctucture.database.adapter.module_core;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_core.PeriodoDomainEntitiy;
import com.zentry.sed.core.repositories.module_core.IPeriodoRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_core.PeriodoMapper;
import com.zentry.sed.infrasctucture.repositories.module_core.PeriodoJPARepository;

@Repository
public class PeriodoRepositoryAdapter implements IPeriodoRepository {
    
    private final PeriodoJPARepository periodoJPARepository;

    public PeriodoRepositoryAdapter(PeriodoJPARepository periodoJPARepository){
        this.periodoJPARepository = periodoJPARepository;
    }

    public Optional<PeriodoDomainEntitiy> findById(String id){
        return this.periodoJPARepository.findById(UUID.fromString(id)).map(PeriodoMapper::toDomain);
    }
}
