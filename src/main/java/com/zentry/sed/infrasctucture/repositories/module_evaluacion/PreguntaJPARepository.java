package com.zentry.sed.infrasctucture.repositories.module_evaluacion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_evaluacion.PreguntaEntity;

public interface PreguntaJPARepository extends JpaRepository<PreguntaEntity , UUID>{
    
}
