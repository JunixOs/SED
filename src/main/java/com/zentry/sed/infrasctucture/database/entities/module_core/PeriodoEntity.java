package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "periodo" , 
    indexes = {
        @Index(name = "idx_periodo" , columnList = "anio,term" , unique = true)
    }
)
@Getter
@Setter
@AllArgsConstructor
public class PeriodoEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_periodo")
    private UUID id;

    @NotNull(message = "Debe proporcionar un año.")
    private Integer anio;

    @NotNull(message = "Debe proporcionar un term.")
    @Size(max = 20 , message = "Debe tener menos de 20 caracteres.")
    private String term;

    @Column(name = "fecha_inicio" , columnDefinition = "DATE")
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_fin" , columnDefinition = "DATE")
    private LocalDate fechaFin;
}
