package com.zentry.sed.infrasctucture.database.adapter.module_docentes;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_docentes.DocenteDomainEntity;
import com.zentry.sed.core.repositories.module_docentes.IDocenteRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_docentes.DocenteMapper;
import com.zentry.sed.infrasctucture.repositories.module_docentes.DocenteJPARepository;

@Repository
public class DocenteRepositoryAdapter implements IDocenteRepository {
    
    private final DocenteJPARepository docenteJPARepository;

    public DocenteRepositoryAdapter(DocenteJPARepository docenteJPARepository){
        this.docenteJPARepository = docenteJPARepository;
    }
    
    public void save(DocenteDomainEntity docenteDomainEntity) {
        docenteJPARepository.save(DocenteMapper.toEntity(docenteDomainEntity));
    }
    
    public void deleteById(String id) {

    }
    
    public Optional<DocenteDomainEntity> findById(String id) {
        return docenteJPARepository.findById(UUID.fromString(id))
            .map(d -> DocenteMapper.toDomain(d));
    }
}
