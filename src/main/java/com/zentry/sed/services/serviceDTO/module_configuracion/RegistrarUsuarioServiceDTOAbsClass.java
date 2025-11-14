package com.zentry.sed.services.serviceDTO.module_configuracion;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RegistrarUsuarioServiceDTOAbsClass {
    private String nombreCompleto;
    private String correo;
    private String password;
    private String estadoUsuarioId;
    private List<String> rolId;
}
