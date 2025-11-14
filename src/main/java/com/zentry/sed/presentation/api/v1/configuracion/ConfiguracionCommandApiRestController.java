package com.zentry.sed.presentation.api.v1.configuracion;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zentry.sed.presentation.models.mappers.module_configuracion.RegistrarUsuarioMapper;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarComisionRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarDocenteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarEstudianteRequestDTO;
import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.services.module_configuracion.ConfiguracionCommandService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/module_configuracion/")
public class ConfiguracionCommandApiRestController {
    
    private final ConfiguracionCommandService configuracionCommandService;

    public ConfiguracionCommandApiRestController(ConfiguracionCommandService configuracionCommandService){
        this.configuracionCommandService = configuracionCommandService;
    }
    
    @PostMapping("/registrar-estudiante")
    public ResponseEntity<GeneralResponseDTO<?>> registrarEstudiante( // La "?" indica que lo de adentro puede ser cualquier tipo de dato
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
            String registerMessage = configuracionCommandService.registrarEstudiante(
                RegistrarUsuarioMapper.presentationToService(registrarEstudianteRequestDTO)
            );

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

    @PostMapping("/registrar-docente")
    public ResponseEntity<GeneralResponseDTO<?>> registrarDocente( // La "?" indica que lo de adentro puede ser cualquier tipo de dato
        @Valid @ModelAttribute("registrarDocenteRequestDTO") RegistrarDocenteRequestDTO registrarDocenteRequestDTO , 
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
                    "Ocurrio un error.", 
                    errorMessages
                )
            );
        }
        
        try {
            String registerMessage = configuracionCommandService.registrarDocente(
                RegistrarUsuarioMapper.presentationToService(registrarDocenteRequestDTO)
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    true, 
                    registerMessage, 
                    null
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Ocurrio un error al procesar la solicitud", 
                    null
                )
            );
        }
    }

    @PostMapping("/registrar-comision")
    public ResponseEntity<GeneralResponseDTO<?>> registrarComision(
        @Valid @ModelAttribute("registrarComisionRequestDTO") RegistrarComisionRequestDTO registrarComisionRequestDTO , 
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
                    "Ocurrio un error.", 
                    errorMessages
                )
            );
        }
        
        try {
            String registerMessage = configuracionCommandService.registrarComision(
                RegistrarUsuarioMapper.presentationToService(registrarComisionRequestDTO)
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    true, 
                    registerMessage, 
                    null
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new GeneralResponseDTO<>(
                    false, 
                    "Ocurrio un error al procesar la solicitud", 
                    null
                )
            );
        }
    }
}
