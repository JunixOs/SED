package com.zentry.sed.presentation.models.requestDTO.module_configuracion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegistrarDocenteRequestDTO extends RegistrarUsuarioRequestDTOAbsClass{
    @NotBlank(message = "Debe proporcionar el departamento.")
    @Size(max = 100 , message = "El departamento no debe tener mas de 100 caracteres.")
    private String departamento;
    
    private Integer antiguedad;
    
    @NotBlank(message = "Debe proporcionar el grado academico.")
    @Size(max = 100 , message = "El grado academico no debe tener mas de 100 caracteres.")
    private String gradoAcademico;
}
