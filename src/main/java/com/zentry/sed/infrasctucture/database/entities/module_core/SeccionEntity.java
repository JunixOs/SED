package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_docentes.DocenteEntity;

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
    name = "seccion" , 
    indexes = {
        @Index(name = "idx_seccion" , columnList = "curso_id,periodo_id,codigo_seccion" , unique = true)
    }
)
@Getter
@Setter
public class SeccionEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_seccion" , updatable = false , nullable = false , 
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id" , nullable = false)
    private CursoEntity curso;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id" , nullable = false)
    private PeriodoEntity periodo;
    
    @Column(name = "codigo_seccion" , length = 20 , nullable = true)
    private String codigoSeccion;
    
    @Column(name = "id_modalidad_seccion" , length = 20 , nullable = false)
    private ModalidadSeccionEntity modalidad;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_titular_id" , nullable = true)
    private DocenteEntity docente;
}
