package com.zentry.sed.infrasctucture.database.entities.module_docentes;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "docente"
)
@Getter
@Setter
public class DocenteEntity {
    
    @Id
    @GeneratedValue
    @Column(
        name = "id_docente", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id" , nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "departamento" , length = 100 , nullable = false)
    private String departamento;

    @Column(name = "antiguedad" , nullable = true)
    private Integer antiguedad;

    @Column(name = "grado_academico" , length = 100 , nullable = true)
    private String gradoAcademico;
}
