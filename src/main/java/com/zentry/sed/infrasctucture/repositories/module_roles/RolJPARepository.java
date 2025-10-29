package com.zentry.sed.infrasctucture.repositories.module_roles;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

public interface RolJPARepository extends JpaRepository<RolEntity , UUID>{
    Optional<RolEntity> findByNombre(String nombre);
}
