package com.zentry.sed.infrasctucture.repositories.module_core;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_core.ModalidadSeccionEntity;

public interface ModalidadSeccionJPARepository extends JpaRepository<ModalidadSeccionEntity , UUID>{

}
