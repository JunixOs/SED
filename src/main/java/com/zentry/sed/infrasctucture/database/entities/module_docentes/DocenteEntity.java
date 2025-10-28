package com.zentry.sed.infrasctucture.database.entities.module_docentes;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @NotNull(message = "Debe proporcionar un departamento.")
    @Size(max = 100 , message = "El departamento debe tener menos de 100 caracteres.")
    private String departamento;

    private Integer antiguedad;

    @Size(max = 100 , message = "El grado academico debe tener menos de 100 caracteres.")
    @Column(name = "grado_academico")
    private String gradoAcademico;
}
