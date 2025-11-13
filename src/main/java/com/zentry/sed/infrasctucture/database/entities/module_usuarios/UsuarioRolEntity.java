package com.zentry.sed.infrasctucture.database.entities.module_usuarios;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_roles.RolEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "usuario_rol" , 
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UsuarioRol_UQ" , 
            columnNames =  {"usuario_id" , "rol_id"}
        )
    }
)
@Getter
@Setter
public class UsuarioRolEntity {

    @Id
    @GeneratedValue
    @Column(
        name = "id_usuario_rol", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id" , nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id" , nullable = false)
    private RolEntity rol;
}
