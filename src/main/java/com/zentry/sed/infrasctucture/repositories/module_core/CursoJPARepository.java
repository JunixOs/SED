package com.zentry.sed.infrasctucture.repositories.module_core;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_core.CursoEntity;

public interface CursoJPARepository extends JpaRepository<CursoEntity , UUID>{
    public List<CursoEntity> findAllById(List<UUID> ids);
}
