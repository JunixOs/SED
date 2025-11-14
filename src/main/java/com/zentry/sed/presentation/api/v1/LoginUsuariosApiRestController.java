package com.zentry.sed.presentation.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.zentry.sed.presentation.models.requestDTO.module_usuarios.LoginRequestDTO;
import com.zentry.sed.services.module_usuarios.LoginUsuarioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/module_usuarios/auth")
public class LoginUsuariosApiRestController {

    @Autowired
    private LoginUsuarioService authService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(
        @Valid @ModelAttribute("loginRequestDTO") LoginRequestDTO loginRequestDTO ,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
        }

        try {
            String loginMessage = authService.login(
                loginRequestDTO.getCorreo(), 
                loginRequestDTO.getPassword()
            );
            return ResponseEntity.status(HttpStatus.OK).body(loginMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error al iniciar sesion.");
        }
    }
    
}
