package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
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
    @UuidGenerator
    @Column(name = "id_pregunta")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modulo_id")
    private ModuloEntity modulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criterio_id")
    private CriterioEntity criterio;

    @NotNull(message = "Debe especificar un enunciado.")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String enunciado;

    private Integer orden;

    @Digits(integer = 3 , fraction = 3 , message = "Solo se permiten numeros entre 0 y 999.999") // Aplica para JAVA, validacion
    @Column(name = "peso_pregunta" , precision = 6 , scale = 3) // Solo aplica para SQL
    @DecimalMin("0.000")
    @DecimalMax("999.999")
    private BigDecimal pesoPregunta;
}
