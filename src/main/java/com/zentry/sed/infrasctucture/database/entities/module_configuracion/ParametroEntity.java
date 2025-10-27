package com.zentry.sed.infrasctucture.database.entities.module_configuracion;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "parametro"
)
@Getter
@Setter
public class ParametroEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id_parametro")
    private UUID id;

    @NotNull(message = "Debe especificar un nombre.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;
    
    @NotNull(message = "Debe especificar un valor.")
    @Size(max = 200 , message = "El valor debe tener menos de 200 caracteres.")
    private String valor;
}
