package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "criterio"
)
@Getter
@Setter
public class CriterioEntity {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_criterio")
    private UUID id;

    @NotNull(message = "Debe proporcionar un nombre.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String descripcion;
}
