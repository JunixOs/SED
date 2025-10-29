package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;

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
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "matricula" , 
    indexes = {
        @Index(name = "idx_matricula" , columnList = "estudiante_id,seccion_id" , unique = true)
    }
)
@Getter
@Setter
public class MatriculaEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_matricula" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @NotNull(message = "Debe especificar una fecha de matricula.")
    @Column(name = "fecha_matricula" , columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaMatricula;

    @NotNull(message = "Debe especificar un estado.")
    @Size(max = 20 , message = "El estado debe tener menos de 20 caracteres.")
    private String estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id")
    private SeccionEntity seccion;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;
}
