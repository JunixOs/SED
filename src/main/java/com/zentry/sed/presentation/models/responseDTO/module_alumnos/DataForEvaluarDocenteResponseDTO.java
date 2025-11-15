package com.zentry.sed.presentation.models.responseDTO.module_alumnos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataForEvaluarDocenteResponseDTO {

    private String preguntaId;
    private String preguntaModuloId;

    private String preguntaCriterioNombre;
    private String preguntaCriterioDescripcion;

    private String preguntaEnunciado;
    private Integer preguntaOrden;
    private BigDecimal preguntapesoPregunta;
}
