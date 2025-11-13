package com.zentry.sed.infrasctucture.repositories.module_docentes;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;

public interface DocenteJPARepository extends JpaRepository<DocenteEntity , UUID>{
    
}
