package com.zentry.sed.infrasctucture.database.entities.module_alumnos;

import java.util.UUID;

import com.zentry.sed.infrasctucture.database.entities.module_usuarios.UsuarioEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "estudiante"
)
@Getter
@Setter
@AllArgsConstructor
public class EstudianteEntity {

    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @NotNull(message = "Debe especificar el semestre.")
    @Size(max = 10 , message = "El semestre debe tener menos de 10 caracteres.")
    private String semestre;

    @NotNull(message = "Debe especificar la carrera.")
    @Size(max = 100 , message = "La carrera debe tener menos de 100 caracteres.")
    private String carrera;

    @Size(max = 20 , message = "El codigo debe tener menos de 20 caracteres.")
    private String codigo;
}