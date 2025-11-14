package com.zentry.sed.presentation.models.requestDTO.module_configuracion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegistrarEstudianteRequestDTO extends RegistrarUsuarioRequestDTOAbsClass {
    @NotBlank(message = "Debe proporcionar el semestre.")
    @Size(max = 10 , message = "El semestre no debe tener mas de 10 caracteres.")
    private String semestre;
    
    @NotBlank(message = "Debe proporcionar el semestre.")
    @Size(max = 100 , message = "La carrera no debe tener mas de 100 caracteres.")
    private String carrera;
    
    @Size(max = 20 , message = "El codigo del estudiante no debe tener mas de 20 caracteres.")
    private String codigoEstudiante;
}
