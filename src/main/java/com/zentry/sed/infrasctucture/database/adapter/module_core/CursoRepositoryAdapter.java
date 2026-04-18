package com.zentry.sed.infrasctucture.database.adapter.module_core;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_core.CursoDomainEntity;
import com.zentry.sed.core.repositories.module_core.ICursoRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_core.CursoMapper;
import com.zentry.sed.infrasctucture.repositories.module_core.CursoJPARepository;

@Repository
public class CursoRepositoryAdapter implements ICursoRepository {
    
    private final CursoJPARepository cursoJPARepository;

    public CursoRepositoryAdapter(CursoJPARepository cursoJPARepository){
        this.cursoJPARepository = cursoJPARepository;
    }

    public List<CursoDomainEntity> findAllById(List<String> ids){
        return cursoJPARepository.findAllById(
            ids.stream()
                .map(UUID::fromString)
                .collect(Collectors.toList())
        ).stream()
        .map(CursoMapper::toDomain)
        .collect(Collectors.toList());
    }
    
    public void save(CursoDomainEntity cursoDomainEntity){
        cursoJPARepository.save(CursoMapper.toEntity(cursoDomainEntity));
    }

    public void deleteById(String id){
        cursoJPARepository.deleteById(UUID.fromString(id));
    }
}
