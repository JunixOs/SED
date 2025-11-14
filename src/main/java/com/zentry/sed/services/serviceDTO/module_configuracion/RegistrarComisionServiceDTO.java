package com.zentry.sed.services.serviceDTO.module_configuracion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrarComisionServiceDTO extends RegistrarUsuarioServiceDTOAbsClass {
    private String facultad;
    private String periodoId;
    private String rolMiembro;
}
