package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "pregunta"
)
@Setter
@Getter
public class PreguntaEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_pregunta" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modulo_id" , nullable = false)
    private ModuloEntity modulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criterio_id" , nullable = true)
    private CriterioEntity criterio;

    @Lob
    @Column(name = "enunciado" , columnDefinition = "TEXT" , nullable = false)
    private String enunciado;

    @Column(name = "orden" , nullable = true)
    private Integer orden;

    @Column(name = "peso_pregunta" , precision = 6 , scale = 3 , nullable = true) // Solo aplica para SQL
    private BigDecimal pesoPregunta;
}
