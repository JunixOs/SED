package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class SeccionEntity {
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_seccion")
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id")
    private PeriodoEntity periodo;
    
    @Size(max = 20 , message = "El codigo debe tener menos de 20 caracteres.")
    @Column(name = "codigo_seccion")
    private String codigoSeccion;
    
    @Size(max = 20 , message = "La modalidad debe tener menos de 20 caracteres.")
    private String modalidad;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_titular_id")
    private DocenteEntity docente;
}
