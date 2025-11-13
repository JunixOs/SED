package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "matricula" , 
    uniqueConstraints = {
        @UniqueConstraint(
            name = "Matricula_Estudiante_Seccion_UQ" ,
            columnNames =  {"estudiante_id" , "seccion_id"}
        )
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

    @Column(name = "fecha_matricula" , columnDefinition = "TIMESTAMP" , nullable = false)
    private LocalDateTime fechaMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_matricula_id" , nullable = false)
    private EstadoMatriculaEntity estadoMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id" , nullable = false)
    private SeccionEntity seccion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id" , nullable = false)
    private EstudianteEntity estudiante;
}
