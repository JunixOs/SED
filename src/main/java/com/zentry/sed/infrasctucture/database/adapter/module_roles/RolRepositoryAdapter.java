package com.zentry.sed.infrasctucture.database.adapter.module_roles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.zentry.sed.core.entities.module_roles.RolDomainEntity;
import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.infrasctucture.database.mappers.module_roles.RolMapper;
import com.zentry.sed.infrasctucture.repositories.module_roles.RolJPARepository;

@Repository
public class RolRepositoryAdapter implements IRolRepository {
    
    private final RolJPARepository rolJpaRepository;

    RolRepositoryAdapter(RolJPARepository rolJpaRepository){
        this.rolJpaRepository = rolJpaRepository;
    }

    @Override
    public void save(RolDomainEntity rol) {
        rolJpaRepository.save(
            RolMapper.toEntity(rol)
        );
    }

    @Override
    public List<RolDomainEntity> findAll(){
        return rolJpaRepository.findAll()
            .stream()
            .map(RolMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<RolDomainEntity> findById(String id){
        return rolJpaRepository.findById(
            UUID.fromString(id)
        ).map(RolMapper::toDomain);
    }
}
