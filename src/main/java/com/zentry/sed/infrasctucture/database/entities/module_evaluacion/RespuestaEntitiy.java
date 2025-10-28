package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RespuestaEntitiy {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_respuesta")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_id")
    private EvaluacionEntity evaluacion;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id")
    private PreguntaEntity pregunta;

    @NotNull(message = "Debe especificar un valor.")
    private Integer valor;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String comentario;
}
