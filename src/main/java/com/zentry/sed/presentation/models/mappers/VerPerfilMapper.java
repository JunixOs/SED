package com.zentry.sed.presentation.models.mappers;

import java.io.IOException;
import java.util.List;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.EstadoUsuarioDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.VerPerfilResponseDTO;

public class VerPerfilMapper {
    public static VerPerfilResponseDTO domainToResponse(List<Object> dataFromUser) throws IOException{
        VerPerfilResponseDTO verPerfilResponseDTO = new VerPerfilResponseDTO();
        
        for(Object domainEntity : dataFromUser){
            if(domainEntity instanceof UsuarioDomainEntity UsrDom){
                verPerfilResponseDTO.setNombreCompleto(UsrDom.getNombreCompleto());
                verPerfilResponseDTO.setCorreo(UsrDom.getCorreo());
                verPerfilResponseDTO.setCreadoEn(UsrDom.getCreadoEn());
                verPerfilResponseDTO.setActualizadoEn(UsrDom.getActualizadoEn());
            } else if (domainEntity instanceof EstudianteDomainEntity EstDom){
                verPerfilResponseDTO.setSemestre(EstDom.getSemestre());
                verPerfilResponseDTO.setCarrera(EstDom.getCarrera());
                verPerfilResponseDTO.setCodigoEstudiante(EstDom.getCodigoEstudiante());
            } else if (domainEntity instanceof EstadoUsuarioDomainEntity EstUsrDom){
                verPerfilResponseDTO.setCodigoEstadoUsuario(EstUsrDom.getCodigo());
                verPerfilResponseDTO.setEtiquetaEstadoUsuario(EstUsrDom.getEtiqueta());
            } else {
                throw new IOException();
            }
        }

        return verPerfilResponseDTO;
    }
}
