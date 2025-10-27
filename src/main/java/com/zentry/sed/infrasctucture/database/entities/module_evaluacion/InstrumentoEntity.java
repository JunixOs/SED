package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_core.PeriodoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "instrumento"
)
@Getter
@Setter
@AllArgsConstructor
public class InstrumentoEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_instrumento")
    private UUID id;

    @NotNull
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id")
    private PeriodoEntity periodo;

    @NotNull
    private Integer version;

    @NotNull
    private Boolean vigente = true;

    @Column(name = "creado_en" , columnDefinition = "TIMESTAMP")
    private LocalDateTime creadoEn;
}
