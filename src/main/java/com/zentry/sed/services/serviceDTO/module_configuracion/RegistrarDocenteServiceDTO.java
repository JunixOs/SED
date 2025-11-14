package com.zentry.sed.services.serviceDTO.module_configuracion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarDocenteServiceDTO extends RegistrarUsuarioServiceDTOAbsClass {
    private String departamento;
    private Integer antiguedad;
    private String gradoAcademico;
}
