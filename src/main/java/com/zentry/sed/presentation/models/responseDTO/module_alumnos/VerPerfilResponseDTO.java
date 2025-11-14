package com.zentry.sed.presentation.models.responseDTO.module_alumnos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerPerfilResponseDTO {
    // Usuario
    private String nombreCompleto;
    private String correo;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
    
    // Estudiante
    private String semestre;
    private String carrera;
    private String codigoEstudiante;


    // Estado Usuario
    private String codigoEstadoUsuario;
    private String etiquetaEstadoUsuario;
}
