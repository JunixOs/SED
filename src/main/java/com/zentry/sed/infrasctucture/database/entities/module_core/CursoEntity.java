package com.zentry.sed.infrasctucture.database.entities.module_core;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "curso"
)
@Getter
@Setter
@AllArgsConstructor
public class CursoEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_curso")
    private UUID id;

    @NotNull(message = "Debe proporcionar un nombre.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;

    @NotNull(message = "Debe proporcionar un codigo.")
    @Size(max = 20 , message = "El codigo debe tener menos de 20 caracteres.")
    private String codigo;

    @Size(max = 100 , message = "El nombre de la facultad debe tener menos de 100 caracteres.")
    private String facultad;

    private Integer creditos;
}
