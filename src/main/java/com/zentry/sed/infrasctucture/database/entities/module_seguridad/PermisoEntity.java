package com.zentry.sed.infrasctucture.database.entities.module_seguridad;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(
        name = "id_permiso" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "codigo" , length = 100 , nullable = false)
    private String codigo;

    @Column(name = "descripcion" , length = 255 , nullable = true)
    private String descripcion;
}
