package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;

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
import lombok.Setter;

@Entity
@Table(
    name = "instrumento" , 
    indexes = {
        @Index(name = "idx_instrumento" , columnList = "nombre,version" , unique = true)
    }
)
@Getter
@Setter
public class InstrumentoEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_instrumento" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "nombre" , length = 100 , nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id" , nullable = true)
    private PeriodoEntity periodo;

    @Column(name = "version" , nullable = false)
    private Integer version;

    @Column(name = "vigente" , nullable = false)
    private Boolean vigente = true;

    @Column(name = "creado_en" , columnDefinition = "TIMESTAMP" , nullable = true)
    private LocalDateTime creadoEn;
}
