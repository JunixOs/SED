package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.zentry.sed.infrasctucture.database.entities.module_alumnos.EstudianteEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.SeccionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "evaluacion" , 
    indexes = {
        @Index(name = "idx_evaluacion" , columnList = "estudiante_id,seccion_id,docente_id,instrumento_id" , unique = true)
    }
)
@Getter
@Setter
@AllArgsConstructor
public class EvaluacionEntity {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_evaluacion")
    private UUID id;

    @NotNull(message = "Debe especificar una fecha.")
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;

    @NotNull(message = "Debe especificar un estado")
    @Size(max = 20 , message = "El estado debe tener menos de 20 caracteres.")
    private String estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id")
    private SeccionEntity seccion;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id")
    private DocenteEntity docente;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrumento_id")
    private InstrumentoEntity instrumento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;

    @Column(name = "token_anonimo")
    private UUID tokenAnonimo;

    @Size(max = 20 , message = "El canal debe tener menos de 20 caracteres.")
    private String canal;

    @Lob
    @Column(name = "comentario_general" , columnDefinition = "TEXT")
    private String comentarioGeneral;
}
