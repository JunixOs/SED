package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "respuesta" , 
    indexes = {
        @Index(name = "idx_respuesta" , columnList = "evaluacion_id,pregunta_id" , unique = true)
    }
)
@Getter
@Setter
public class RespuestaEntitiy {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_respuesta" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_id" , nullable = false)
    private EvaluacionEntity evaluacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id" , nullable = false)
    private PreguntaEntity pregunta;

    @Column(name = "valor" , nullable = false)
    private Integer valor;

    @Lob
    @Column(name = "comentario" , columnDefinition = "TEXT" , nullable = true)
    private String comentario;
}
