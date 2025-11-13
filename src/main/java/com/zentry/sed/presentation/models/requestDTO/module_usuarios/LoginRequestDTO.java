package com.zentry.sed.presentation.models.requestDTO.module_usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {
    
    @NotBlank(message = "Debe especificar el correo.")
    @Email(message = "Debe especificar un correo valido.")
    @Size(max = 254 , message = "El correo no debe tener más de 254 caracteres.")
    private String correo;
    
    @NotBlank(message = "Debe ingresar la contraseña.")
    @Size(min = 8 , max = 100 , message = "La contraseña debe tener entre 8 y 100 caracteres de longitud.")
    private String password;

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
}
