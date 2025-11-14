package com.zentry.sed.presentation.api.v1.configuracion;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.services.module_configuracion.ConfiguracionQueryService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/module_configuracion/")
public class ConfiguracionQueryApiRestController {
    
    @Autowired
    private ConfiguracionQueryService configuracionQueryService;

    @GetMapping({"/registrar-estudiante" , "/registrar-docente" , "/registrar-comision"})
    public ResponseEntity<GeneralResponseDTO<?>> sendDataForRegister() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                new GeneralResponseDTO<Map<String , List<String>>>(
                    false, 
                    null, 
                    configuracionQueryService.sendDataForRegister()
                )
            );
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
}
