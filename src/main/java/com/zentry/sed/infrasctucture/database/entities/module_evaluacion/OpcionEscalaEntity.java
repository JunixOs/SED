package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(
    name = "opcion_escala" , 
    indexes = {
        @Index(name = "idx_opcion_escala" , columnList = "escala_id,valor" , unique = true)
    }
)
@Getter
public class OpcionEscalaEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_opcion_escala" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escala_id" , nullable = false)
    private EscalaEntity escala;

    @Column(name = "valor" , nullable = false)
    private Integer valor;

    @Column(name = "etiqueta" , nullable = false , length = 50)
    private String etiqueta;
}
