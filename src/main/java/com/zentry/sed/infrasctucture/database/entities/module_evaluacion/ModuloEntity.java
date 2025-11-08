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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrumento_id" , nullable = false)
    private InstrumentoEntity instrumento;

    @Column(name = "nombre" , length = 100 , nullable = false)
    private String nombre;

    @Column(name = "orden" , nullable = true)
    private Integer orden;

    @Column(name = "peso_modulo" , precision = 6 , scale = 3 , nullable = true)
    private BigDecimal pesoModulo;
}
