package com.zentry.sed.infrasctucture.repositories.module_core;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zentry.sed.infrasctucture.database.entities.module_core.SeccionEntity;

public interface SeccionJPARepository extends JpaRepository<SeccionEntity , UUID>{
    @Query("SELECT s.curso.id FROM SeccionEntity s WHERE s.id = :id")
    public List<UUID> findAllCursoIdById(@Param("id") List<UUID> ids);
}
