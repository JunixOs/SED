package com.zentry.sed.services.module_configuracion.usecases.command;

import java.io.IOException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_docentes.DocenteDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_docentes.IDocenteRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarDocenteServiceDTO;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarUsuarioServiceDTOAbsClass;

@Component
public class RegistrarDocenteUseCase {
    
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioRolRepository usuarioRolRepository;
    private final IEstadoUsuarioRepository estadoUsuarioRepository;
    private final IDocenteRepository docenteRepository;

    public RegistrarDocenteUseCase(
        PasswordEncoder passwordEncoder,
        IUsuarioRepository usuarioRepository,
        IUsuarioRolRepository usuarioRolRepository,
        IEstadoUsuarioRepository estadoUsuarioRepository,
        IDocenteRepository docenteRepository
    ){
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
        this.docenteRepository = docenteRepository;
    }

    public String execute(
        RegistrarUsuarioServiceDTOAbsClass registrarUsuarioServiceDTOAbsClass
    ) throws IOException {

        UsuarioDomainEntity usuarioDomainEntity = UsuarioDomainEntity.create(
            registrarUsuarioServiceDTOAbsClass.getNombreCompleto(),
            registrarUsuarioServiceDTOAbsClass.getCorreo(),
            passwordEncoder.encode(registrarUsuarioServiceDTOAbsClass.getPassword()),
            estadoUsuarioRepository.findById(
                registrarUsuarioServiceDTOAbsClass.getEstadoUsuarioId()
            ).orElse(null) 
        );

        usuarioRepository.save(usuarioDomainEntity);

        String registeredUserId = usuarioRepository.findByCorreo(registrarUsuarioServiceDTOAbsClass.getCorreo())
            .map(u -> u.getId()).orElse(null);

        if(registeredUserId == null){
            throw new IOException();
        }

        for(String rolId : registrarUsuarioServiceDTOAbsClass.getRolId()){
            usuarioRolRepository.save(registeredUserId, rolId);
        }

        if (registrarUsuarioServiceDTOAbsClass instanceof RegistrarDocenteServiceDTO RegDoc) {
            DocenteDomainEntity docenteDomainEntity = DocenteDomainEntity.create(
                registeredUserId , 
                RegDoc.getDepartamento(), 
                RegDoc.getAntiguedad(), 
                RegDoc.getGradoAcademico()
            );

            docenteRepository.save(docenteDomainEntity);
            return "Usuario Docente registrado con exito";
        } else {
            throw new IOException();
        }
    }

}
