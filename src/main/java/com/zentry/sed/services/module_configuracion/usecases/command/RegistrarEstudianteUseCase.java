package com.zentry.sed.services.module_configuracion.usecases.command;

import java.io.IOException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarEstudianteServiceDTO;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarUsuarioServiceDTOAbsClass;

@Component
public class RegistrarEstudianteUseCase {
    
    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioRolRepository usuarioRolRepository;
    private final IEstadoUsuarioRepository estadoUsuarioRepository;
    
    private final IEstudianteRepository estudianteRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrarEstudianteUseCase(
        IUsuarioRepository usuarioRepository,
        IUsuarioRolRepository usuarioRolRepository,
        IRolRepository rolRepository,
        IEstadoUsuarioRepository estadoUsuarioRepository,

        IEstudianteRepository estudianteRepository , 
        PasswordEncoder passwordEncoder
    ){
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;

        this.estudianteRepository = estudianteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String execute(
        RegistrarUsuarioServiceDTOAbsClass registrarUsuarioServiceDTOAbsClass
    ) throws IOException {
        UsuarioDomainEntity usuarioDomainEntity = UsuarioDomainEntity.create(
            registrarUsuarioServiceDTOAbsClass.getNombreCompleto() ,
            registrarUsuarioServiceDTOAbsClass.getCorreo() ,
            passwordEncoder.encode(registrarUsuarioServiceDTOAbsClass.getPassword()) , 
            estadoUsuarioRepository.findById(registrarUsuarioServiceDTOAbsClass.getEstadoUsuarioId()).orElse(null)
        );

        usuarioRepository.save(usuarioDomainEntity);

        String registeredUsuarioId = usuarioRepository.findByCorreo(registrarUsuarioServiceDTOAbsClass.getCorreo()).map(id -> id.toString()).orElse(null);

        if (registeredUsuarioId == null) {
            throw new IOException(); // Siempre debes especificar que la funciona puede arrojar un error
        }

        for(String rolId : registrarUsuarioServiceDTOAbsClass.getRolId()){
            usuarioRolRepository.save(
                registeredUsuarioId , 
                rolId
            );
        }

        if (registrarUsuarioServiceDTOAbsClass instanceof RegistrarEstudianteServiceDTO RegEst) {
            EstudianteDomainEntity estudianteDomainEntity = EstudianteDomainEntity.create(
                registeredUsuarioId , 
                RegEst.getSemestre() , 
                RegEst.getCarrera() , 
                RegEst.getCodigoEstudiante()
            );
            
            estudianteRepository.save(estudianteDomainEntity);

            return "Usuario Estudiante registrado con extio.";
            
        } else {
            throw new IOException();
        }
    }
}
