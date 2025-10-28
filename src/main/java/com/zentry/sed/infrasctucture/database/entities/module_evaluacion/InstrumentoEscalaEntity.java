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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "instrumento_escala" , 
    indexes = {
        @Index(name = "idx_instrumento_escala" , columnList = "instrumento_id,escala_id" , unique = true)
    }
)
@Getter
@Setter
public class InstrumentoEscalaEntity {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_instrumento_escala")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrumento_id")
    private InstrumentoEntity instrumento;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escala_id")
    private EscalaEntity escala;
}
