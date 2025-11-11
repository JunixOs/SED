package com.zentry.sed.presentation.models.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDTO {
    /*
        Aqui solo van validaciones, no anotaciones JPA
    */

    @NotBlank(message = "Debe seleccionar un rol.")
    private String rolId;

    @NotBlank(message = "Debe proporcionar su nombre completo.")
    @Size(max = 100 , message = "El nombre debe tener menos de 100 caracteres.")
    private String nombreCompleto;

    @NotBlank(message = "Debe proporcionar un correo.")
    @Size(max = 254 , message = "El correo debe tener menos de 254 caracteres.")
    private String correo;

    @NotBlank(message = "Debe proporcionar un hash.")
    @Size(max = 128 , message = "El hash debe tener menos de 128 caracteres.")
    private String password;

    @Size(max = 20 , message = "El estado debe tener menos de 20 caracteres.")
    private String estado;
}
