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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
@Table(
    name = "escala_opcion" , 
    indexes = {
        @Index(name = "idx_escala_opcion" , columnList = "escala_id,valor" , unique = true)
    }
)
@Getter
public class EscalaOpcionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_escala_opcion" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escala_id")
    private EscalaEntity escala;

    @NotNull(message = "Debe proporcionar un valor.")
    private Integer valor;

    @NotNull(message = "Debe proporcionar una etiqueta.")
    @Size(max = 50 , message = "La etiqueta debe tener menos de 50 caracteres.")
    private String etiqueta;
}
