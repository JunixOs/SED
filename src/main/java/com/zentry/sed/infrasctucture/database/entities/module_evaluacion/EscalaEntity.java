package com.zentry.sed.infrasctucture.database.entities.module_evaluacion;

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
    name = "escala"
)
@Getter
@Setter
@AllArgsConstructor
public class EscalaEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_escala")
    private UUID id;

    @NotNull(message = "Debe proporcionar un nombre")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;
}
