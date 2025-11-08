package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

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
    name = "estado_evaluacion"
)
@Getter
@Setter
public class EstadoEvaluacionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_estado_evaluacion", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "codigo" , length = 30 , nullable = false)
    private String codigo;

    @Column(name = "etiqueta" , length = 50 , nullable = true)
    private String etiqueta;
}
