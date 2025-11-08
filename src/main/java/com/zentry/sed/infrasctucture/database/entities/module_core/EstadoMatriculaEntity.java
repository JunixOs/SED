package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "estado_matricula"
)
public class EstadoMatriculaEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_estado_matricula" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "codigo" , length = 30 , nullable = false)
    private String codigo;

    @Column(name = "etiqueta" , length = 50 , nullable = true)
    private String etiqueta;
}
