package com.zentry.sed.infrasctucture.database.entities.module_alumnos;

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
    name = "estudiante"
)
@Getter
@Setter
public class EstudianteEntity {

    @Id
    @GeneratedValue
    @Column(
        name = "id_estudiante", updatable = false, nullable = false,
        columnDefinition = "UUID DEFAULT gen_random_uuid()"
    )
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario" , nullable = false)
    private UsuarioEntity usuario;

    @Column(name = "semestre" , length = 10 , nullable = false)
    private String semestre;

    @Column(name = "carrera" , length = 100 , nullable = false)
    private String carrera;

    @Column(name = "codigo" , length = 20 , nullable = true)
    private String codigo;
}