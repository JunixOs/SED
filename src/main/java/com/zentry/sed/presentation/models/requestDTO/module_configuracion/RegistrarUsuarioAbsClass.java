package com.zentry.sed.presentation.models.requestDTO.module_configuracion;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public abstract class RegistrarUsuarioAbsClass {
    @NotBlank(message = "Debe proporcionar sus nombres.")
    @Size(max = 100 , message = "Sus nombres no deben tener más de 100 caracteres.")
    private String nombreCompleto;

    @NotBlank(message = "Debe proporcionar un correo.")
    @Email(message = "Debe escribir un correo valido.")
    @Size(max = 254 , message = "El correo no debe tener más de 254 caracteres.")
    private String correo;
    
    @NotBlank(message = "Debe colocar una contraseña.")
    @Size(min = 8 , max = 100 , message = "La contraseña debe tener entre 8 y 100 caracteres de longitud.")
    private String password;

    @NotBlank(message = "Debe proporcionar un estado al usuario.")
    private String estadoUsuarioId;
    
    @NotEmpty(message = "Debe especificar al menos un rol.")
    private List<String> rolId;
}
