package com.zentry.sed.presentation.models.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    /*
        Aqui solo van validaciones, no anotaciones JPA
    */

    @NotNull(message = "Debe seleccionar un rol.")
    private String rolId;

    @NotNull(message = "Debe proporcionar un nombre.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombre;

    @NotNull(message = "Debe proporcionar un correo.")
    @Size(max = 254 , message = "El correo debe tener menos de 254 caracteres.")
    private String correo;

    @NotNull(message = "Debe proporcionar un hash.")
    @Size(max = 128 , message = "El hash debe tener menos de 128 caracteres.")
    private String passwordHash;

    @Size(max = 20 , message = "El estado debe tener menos de 20 caracteres.")
    private String estado;

    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
