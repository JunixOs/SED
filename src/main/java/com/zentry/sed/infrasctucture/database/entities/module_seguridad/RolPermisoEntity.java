package com.zentry.sed.infrasctucture.database.entities.module_seguridad;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "rol_permiso" , 
    indexes = {
        @Index(name = "idx_rol_permiso" , columnList = "rol_id,permiso_id" , unique = true)
    }
)
@Getter
@Setter
public class RolPermisoEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_rol_permiso" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
        )
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private RolEntity rol;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permiso_id")
    private PermisoEntity permiso;
}
