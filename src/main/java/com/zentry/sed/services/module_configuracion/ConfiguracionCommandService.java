package com.zentry.sed.services.module_configuracion;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.zentry.sed.services.module_configuracion.usecases.command.RegistrarComisionUseCase;
import com.zentry.sed.services.module_configuracion.usecases.command.RegistrarDocenteUseCase;
import com.zentry.sed.services.module_configuracion.usecases.command.RegistrarEstudianteUseCase;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarUsuarioServiceDTOAbsClass;

@Service
public class ConfiguracionCommandService {
    
    private final RegistrarEstudianteUseCase registrarEstudianteUseCase;
    private final RegistrarDocenteUseCase registrarDocenteUseCase;
    private final RegistrarComisionUseCase registrarComisionUseCase;

    public ConfiguracionCommandService(
        RegistrarEstudianteUseCase registrarEstudianteUseCase , 
        RegistrarDocenteUseCase registrarDocenteUseCase , 
        RegistrarComisionUseCase registrarComisionUseCase
    ){
        this.registrarEstudianteUseCase = registrarEstudianteUseCase;
        this.registrarDocenteUseCase = registrarDocenteUseCase;
        this.registrarComisionUseCase = registrarComisionUseCase;
    }

    public String registrarEstudiante(RegistrarUsuarioServiceDTOAbsClass registrarUsuarioServiceDTOAbsClass) throws IOException{
        return registrarEstudianteUseCase.execute(registrarUsuarioServiceDTOAbsClass);
    }

    public String registrarDocente(RegistrarUsuarioServiceDTOAbsClass registrarUsuarioServiceDTOAbsClass) throws IOException{
        return registrarDocenteUseCase.execute(registrarUsuarioServiceDTOAbsClass);
    }

    public String registrarComision(RegistrarUsuarioServiceDTOAbsClass registrarUsuarioServiceDTOAbsClass) throws IOException{
        return registrarComisionUseCase.execute(registrarUsuarioServiceDTOAbsClass);
    }
}
