package com.zentry.sed.presentation.api.v1.module_alumnos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zentry.sed.presentation.models.mappers.module_alumnos.EvaluarDocenteMapper;
import com.zentry.sed.presentation.models.requestDTO.module_alumnos.EvaluarDocenteRequestDTO;
import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.services.module_alumnos.EstudianteCommandService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/module_alumnos")
public class EstudianteCommandApiRestController {
    
    private final EstudianteCommandService estudianteCommandService;

    public EstudianteCommandApiRestController(EstudianteCommandService estudianteCommandService){
        this.estudianteCommandService = estudianteCommandService;
    }

    @PostMapping("/evaluar-docente")
    @PreAuthorize("hasRole('ALUMNO')")
    public ResponseEntity<GeneralResponseDTO<?>> evaluarDocente(
        @RequestBody List<EvaluarDocenteRequestDTO> listEvaluarDocenteRequestDTOs
    ){
        if (listEvaluarDocenteRequestDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Error, no especifico correctamente los parametros.", 
                    null
                )
            );
        }

        try {
            String evaluacionMessage = estudianteCommandService.evaluarDocente(
                listEvaluarDocenteRequestDTOs.stream()
                    .map(EvaluarDocenteMapper::requestToService)
                    .collect(Collectors.toList())
            );
            
            return ResponseEntity.status(HttpStatus.CREATED).body(
                new GeneralResponseDTO<>(
                    true, 
                    evaluacionMessage, 
                    null
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Ocurrio un error al procesar la solicitud", 
                    null
                )
            );
        }
    }
}
