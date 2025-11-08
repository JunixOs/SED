package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_core.MatriculaEntity;
import com.zentry.sed.infrasctucture.database.entities.module_core.SeccionEntity;
import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "evaluacion"
)
@Getter
@Setter
public class EvaluacionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_evaluacion" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @Column(name = "creada_en" , columnDefinition = "TIMESTAMP" , nullable = false)
    private LocalDateTime creadaEn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_evaluacion_id" , nullable = false)
    private EstadoEvaluacionEntity estadoEvaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seccion_id" , nullable = false)
    private SeccionEntity seccion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id" , nullable = false)
    private DocenteEntity docente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrumento_id" , nullable = false)
    private InstrumentoEntity instrumento;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id" , nullable = true)
    private MatriculaEntity matricula;

    @Column(name = "token_anonimo" , nullable = true)
    private UUID tokenAnonimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "canal_id" , nullable = true)
    private CanalEntity canal;

    @Lob
    @Column(name = "comentario_general" , columnDefinition = "TEXT" , nullable = true)
    private String comentarioGeneral;
}
