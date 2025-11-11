package com.zentry.sed.presentation.models.responseDTO.module_alumnos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataForLoginResponseDTO {
    private List<String> listRolesId;
    private List<String> listEstadosUsuarioId;

    public DataForLoginResponseDTO(
        List<String> listRolesId,
        List<String> listEstadosUsuarioId
    ){
        this.listRolesId = listRolesId;
        this.listEstadosUsuarioId = listEstadosUsuarioId;
    }
}
