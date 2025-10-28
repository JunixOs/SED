package com.zentry.sed.infrasctucture.database.entities.module_seguridad;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "permiso"
)
@Getter
@Setter
public class PermisoEntity {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_permiso")
    private UUID id;

    @NotNull(message = "Debe proporcionar un codigo.")
    @Size(max = 100 , message = "El codigo debe tener menos de 100 caracteres.")
    private String codigo;

    @Size(max = 255 , message = "La descripcion debe tener menos de 255 caracteres.")
    private String descripcion;
}
