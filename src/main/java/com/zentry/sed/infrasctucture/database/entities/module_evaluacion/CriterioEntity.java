package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "criterio"
)
@Getter
@Setter
public class CriterioEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_criterio" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "nombre" , length = 100 , nullable = false)
    private String nombre;

    @Lob
    @Column(name = "descripcion" , columnDefinition = "TEXT" , nullable = true)
    private String descripcion;
}
