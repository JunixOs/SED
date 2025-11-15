package com.zentry.sed.presentation.models.requestDTO.module_alumnos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class EvaluarDocenteRequestDTO {
    
    
    @NotBlank(message = "Debe enviar el ID de la evaluacion.")
    private String evaluacionId;

    @NotBlank(message = "Debe enviar el ID de la pregunta.")
    private String preguntaId;

    @NotNull(message = "Debe enviar el valor de la pregunta.")
    private Integer respuestaValor;

    private String respuestaComentario;

}