package com.zentry.sed.presentation.models.mappers.module_configuracion;

import java.io.IOException;

import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarComisionRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarDocenteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarEstudianteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarUsuarioRequestDTOAbsClass;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarComisionServiceDTO;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarDocenteServiceDTO;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarEstudianteServiceDTO;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarUsuarioServiceDTOAbsClass;

public class RegistrarUsuarioMapper {
    public static RegistrarUsuarioServiceDTOAbsClass presentationToService(RegistrarUsuarioRequestDTOAbsClass registrarUsuarioRequestDTOAbsClass) throws IOException{        
        if (registrarUsuarioRequestDTOAbsClass instanceof RegistrarEstudianteRequestDTO EstReq) {
            RegistrarEstudianteServiceDTO registrarEstudianteServiceDTO = new RegistrarEstudianteServiceDTO();
    
            registrarEstudianteServiceDTO.setNombreCompleto(EstReq.getNombreCompleto());
            registrarEstudianteServiceDTO.setCorreo(EstReq.getCorreo());
            registrarEstudianteServiceDTO.setPassword(EstReq.getPassword());
            registrarEstudianteServiceDTO.setEstadoUsuarioId(EstReq.getEstadoUsuarioId());

            registrarEstudianteServiceDTO.setRolId(EstReq.getRolId());
            registrarEstudianteServiceDTO.setSemestre(EstReq.getSemestre());
            registrarEstudianteServiceDTO.setCarrera(EstReq.getCarrera());
            registrarEstudianteServiceDTO.setCodigoEstudiante(EstReq.getCodigoEstudiante());

            return registrarEstudianteServiceDTO;
        } else if (registrarUsuarioRequestDTOAbsClass instanceof RegistrarDocenteRequestDTO RegDoc) {
            RegistrarDocenteServiceDTO registrarDocenteServiceDTO = new RegistrarDocenteServiceDTO();

            registrarDocenteServiceDTO.setNombreCompleto(RegDoc.getNombreCompleto());
            registrarDocenteServiceDTO.setCorreo(RegDoc.getCorreo());
            registrarDocenteServiceDTO.setPassword(RegDoc.getPassword());
            registrarDocenteServiceDTO.setEstadoUsuarioId(RegDoc.getEstadoUsuarioId());

            registrarDocenteServiceDTO.setDepartamento(RegDoc.getDepartamento());
            registrarDocenteServiceDTO.setAntiguedad(RegDoc.getAntiguedad());
            registrarDocenteServiceDTO.setGradoAcademico(RegDoc.getGradoAcademico());

            return registrarDocenteServiceDTO;
        } else if (registrarUsuarioRequestDTOAbsClass instanceof RegistrarComisionRequestDTO RegCom){
            RegistrarComisionServiceDTO registrarComisionServiceDTO = new RegistrarComisionServiceDTO();

            registrarComisionServiceDTO.setNombreCompleto(RegCom.getNombreCompleto());
            registrarComisionServiceDTO.setCorreo(RegCom.getCorreo());
            registrarComisionServiceDTO.setPassword(RegCom.getPassword());
            registrarComisionServiceDTO.setEstadoUsuarioId(RegCom.getEstadoUsuarioId());

            registrarComisionServiceDTO.setFacultad(RegCom.getFacultad());
            registrarComisionServiceDTO.setPeriodoId(RegCom.getPeriodoId());
            registrarComisionServiceDTO.setRolMiembro(RegCom.getRolMiembro());

            return registrarComisionServiceDTO;
        } else {
            throw new IOException();
        }
    }
}
