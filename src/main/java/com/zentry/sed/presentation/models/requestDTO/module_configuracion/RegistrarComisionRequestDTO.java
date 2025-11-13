package com.zentry.sed.presentation.models.requestDTO.module_configuracion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegistrarComisionRequestDTO extends RegistrarUsuarioAbsClass {
    @NotBlank(message = "Debe proporcionar la facultad.")
    @Size(max = 100 , message = "La facultad no debe tener mas de 100 caracteres.")
    private String facultad;
    
    private String periodoId;
    
    @Size(max = 50 , message = "El rol del miembro no debe tener mas de 50 caracteres.")
    private String rolMiembro;
}
