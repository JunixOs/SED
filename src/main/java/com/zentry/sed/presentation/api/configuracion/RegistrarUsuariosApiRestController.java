package com.zentry.sed.presentation.api.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarComisionRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarDocenteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarEstudianteRequestDTO;
import com.zentry.sed.services.module_usuarios.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/v1/module_configuracion")
public class RegistrarUsuariosApiRestController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar-estudiante")
    public ResponseEntity<?> registrarEstudiante( // La "?" indica que lo de adentro puede ser cualquier tipo de dato
        @Valid @ModelAttribute("registrarEstudianteRequestDTO") RegistrarEstudianteRequestDTO registrarEstudianteRequestDTO , 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
        }
        
        try {
            String registerMessage = authService.register(registrarEstudianteRequestDTO);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar al usuario.");
        }
    }

    @PostMapping("/registrar-docente")
    public ResponseEntity<?> registrarDocente( // La "?" indica que lo de adentro puede ser cualquier tipo de dato
        @Valid @ModelAttribute("registrarDocenteRequestDTO") RegistrarDocenteRequestDTO registrarDocenteRequestDTO , 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
        }
        
        try {
            String registerMessage = authService.register(registrarDocenteRequestDTO);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar al usuario.");
        }
    }

    @PostMapping("/registrar-comision")
    public ResponseEntity<?> registrarComision( // La "?" indica que lo de adentro puede ser cualquier tipo de dato
        @Valid @ModelAttribute("registrarComisionRequestDTO") RegistrarComisionRequestDTO registrarComisionRequestDTO , 
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
        }
        
        try {
            String registerMessage = authService.register(registrarComisionRequestDTO);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo registrar al usuario.");
        }
    }
}
