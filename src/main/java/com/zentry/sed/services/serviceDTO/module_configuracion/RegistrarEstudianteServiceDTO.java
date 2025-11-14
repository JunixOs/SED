package com.zentry.sed.services.serviceDTO.module_configuracion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarEstudianteServiceDTO extends RegistrarUsuarioServiceDTOAbsClass {
    private String semestre;
    private String carrera;
    private String codigoEstudiante;
}
