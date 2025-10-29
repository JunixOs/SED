package com.zentry.sed.infrasctucture.repositories.module_core;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;

public interface PeriodoJPARepository extends JpaRepository<PeriodoEntity , UUID>{
    public Optional<PeriodoEntity> findById(UUID id);
}
