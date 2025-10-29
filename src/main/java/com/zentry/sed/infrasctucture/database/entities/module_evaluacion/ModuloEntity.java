package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "modulo"
)
@Getter
@Setter
public class ModuloEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_modulo" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrumento_id")
    private InstrumentoEntity instrumento;

    @NotNull(message = "Debe especificar un nombre.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;

    private Integer orden;

    @Digits(integer = 3 , fraction = 3 , message = "Solo numeros entre 0 y 999.999")
    @Column(name = "peso_modulo" , precision = 6 , scale = 3)
    @DecimalMin("0.000")
    @DecimalMax("999.999")
    private BigDecimal pesoModulo;
}
