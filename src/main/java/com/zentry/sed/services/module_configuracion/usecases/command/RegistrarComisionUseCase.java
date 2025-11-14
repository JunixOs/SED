package com.zentry.sed.services.module_configuracion.usecases.command;

import java.io.IOException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_comision.ComisionDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_comision.IComisionRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarComisionServiceDTO;
import com.zentry.sed.services.serviceDTO.module_configuracion.RegistrarUsuarioServiceDTOAbsClass;

@Component
public class RegistrarComisionUseCase {
    
    private final IUsuarioRepository usuarioRepository;
    private final IEstadoUsuarioRepository estadoUsuarioRepository;
    private final IUsuarioRolRepository usuarioRolRepository;
    private final IComisionRepository comisionRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrarComisionUseCase(
        IUsuarioRepository usuarioRepository,
        IEstadoUsuarioRepository estadoUsuarioRepository,
        IUsuarioRolRepository usuarioRolRepository,
        IComisionRepository comisionRepository,
        PasswordEncoder passwordEncoder
    ){
        this.usuarioRepository = usuarioRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
        this.usuarioRolRepository = usuarioRolRepository;
        this.comisionRepository = comisionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String execute(
        RegistrarUsuarioServiceDTOAbsClass registrarUsuarioServiceDTOAbsClass
    ) throws IOException {
        UsuarioDomainEntity usuarioDomainEntity = UsuarioDomainEntity.create(
            registrarUsuarioServiceDTOAbsClass.getNombreCompleto(),
            registrarUsuarioServiceDTOAbsClass.getCorreo(), 
            passwordEncoder.encode(registrarUsuarioServiceDTOAbsClass.getPassword()), 
            estadoUsuarioRepository.findById(registrarUsuarioServiceDTOAbsClass.getEstadoUsuarioId()).orElse(null)
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

        if (registrarUsuarioServiceDTOAbsClass instanceof RegistrarComisionServiceDTO RegCom) {
            ComisionDomainEntity comisionDomainEntity = ComisionDomainEntity.create(
                registeredUserId, 
                RegCom.getFacultad(), 
                RegCom.getPeriodoId(), 
                RegCom.getRolMiembro()
            );
    
            comisionRepository.save(comisionDomainEntity);
    
            return "Usuario Comision registrado con exito";
        } else {
            throw new IOException();
        }
    }

}
