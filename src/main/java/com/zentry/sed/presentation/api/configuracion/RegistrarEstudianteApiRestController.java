package com.zentry.sed.presentation.api.configuracion;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarEstudianteRequestDTO;
import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.services.module_alumnos.usecases.RegistrarEstudianteUseCase;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/module_configuracion/auth/estudiante")
public class RegistrarEstudianteApiRestController {
    
    @Autowired
    private RegistrarEstudianteUseCase registrarEstudianteUseCase;

    @GetMapping("/registrar")
    public ResponseEntity<GeneralResponseDTO<?>> sendDataForEstudianteRegister() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(registrarEstudianteUseCase.sendDataForRegister());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Ocurrio un error al procesar la solicitud.", 
                    null
                )
            );
        }
        
    }
    
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarEstudiante( // La "?" indica que lo de adentro puede ser cualquier tipo de dato
        @Valid @ModelAttribute("registrarEstudianteRequestDTO") RegistrarEstudianteRequestDTO registrarEstudianteRequestDTO , 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {

            Map<String , String> errorMessages = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                errorField -> errorMessages.put(errorField.getField(), errorField.getDefaultMessage())
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Complete los campos correctamente para continuar.", 
                    errorMessages
                )
            );
        }
        
        try {
            String registerMessage = registrarEstudianteUseCase.registrarEstudiante(registrarEstudianteRequestDTO);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    registerMessage, 
                    null
                )
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    "No se pudo registrar al usuario.", 
                    null)
            );
        }
    }
}
