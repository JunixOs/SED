package com.zentry.sed.infrasctucture.repositories.module_comision;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_comision.ComisionEntity;

public interface ComisionJPARepository extends JpaRepository<ComisionEntity , UUID>{
    public Optional<ComisionEntity> findById(UUID id);
}
