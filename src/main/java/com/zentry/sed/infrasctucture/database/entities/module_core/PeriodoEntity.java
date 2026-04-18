package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "periodo" , 
    uniqueConstraints = {
        @UniqueConstraint(
            name = "Periodo_Anio_Termino_UQ" , 
            columnNames = {"anio" , "termino"}
        )
    }
)
@Getter
@Setter
public class PeriodoEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_periodo" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "anio" , nullable = false)
    private Integer anio;

    @Column(name = "termino" , length = 20 , nullable = false)
    private String termino;

    @Column(name = "fecha_inicio" , columnDefinition = "DATE" , nullable = true)
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_fin" , columnDefinition = "DATE" , nullable = true)
    private LocalDate fechaFin;

    @OneToOne
    @JoinColumn(name = "estado_periodo_id" , nullable = false)
    private EstadoPeriodoEntity estadoPeriodo;
}
