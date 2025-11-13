package com.zentry.sed.infrasctucture.repositories.module_usuarios;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;
import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioRolEntity;

public interface UsuarioRolJPARepository extends JpaRepository<UsuarioRolEntity , UUID>{
    @Query(
        """
            SELECT r FROM UsuarioRolEntity ur
            JOIN ur.rol r
            JOIN ur.usuario u 
            WHERE u.id = :usuarioId
        """
    )
    public List<RolEntity> findRolByUsuarioId(
        @Param("usuarioId") UUID usuarioId
    );
    public void deleteByUsuario_IdAndRol_Id(UUID usuarioId , UUID rolId);
}
