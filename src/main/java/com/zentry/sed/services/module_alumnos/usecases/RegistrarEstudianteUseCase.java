package com.zentry.sed.services.module_alumnos.usecases;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.zentry.sed.core.entities.module_alumnos.EstudianteDomainEntity;
import com.zentry.sed.core.entities.module_usuarios.UsuarioDomainEntity;
import com.zentry.sed.core.repositories.module_alumnos.IEstudianteRepository;
import com.zentry.sed.core.repositories.module_roles.IRolRepository;
import com.zentry.sed.core.repositories.module_usuarios.IEstadoUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRepository;
import com.zentry.sed.core.repositories.module_usuarios.IUsuarioRolRepository;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarEstudianteRequestDTO;
import com.zentry.sed.presentation.models.requestDTO.module_configuracion.RegistrarUsuarioAbsClass;
import com.zentry.sed.presentation.models.responseDTO.GeneralResponseDTO;
import com.zentry.sed.presentation.models.responseDTO.module_alumnos.DataForLoginResponseDTO;

@Component
public class RegistrarEstudianteUseCase {
    
    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioRolRepository usuarioRolRepository;
    private final IRolRepository rolRepository;
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
        this.rolRepository = rolRepository;
        this.usuarioRolRepository = usuarioRolRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;

        this.estudianteRepository = estudianteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public GeneralResponseDTO<DataForLoginResponseDTO> sendDataForRegister(){
        
        List<String> listRolesId = rolRepository.findAll()
            .stream()
            .map(r -> r.getId())
            .collect(Collectors.toList());

        List<String> listEstadosUsuarioId = estadoUsuarioRepository.findAll()
            .stream()
            .map(eu -> eu.getId())
            .collect(Collectors.toList());

        return new GeneralResponseDTO<DataForLoginResponseDTO>(
            true, 
            "Operacion exitosa.", 
            new DataForLoginResponseDTO(
                listRolesId , 
                listEstadosUsuarioId
            )
        );
    }

    public String registrarEstudiante(
        RegistrarUsuarioAbsClass registrarUsuarioRequestDTO
    ) throws IOException {
        UsuarioDomainEntity usuarioDomainEntity = UsuarioDomainEntity.create(
            registrarUsuarioRequestDTO.getNombreCompleto() ,
            registrarUsuarioRequestDTO.getCorreo() ,
            passwordEncoder.encode(registrarUsuarioRequestDTO.getPassword()) , 
            estadoUsuarioRepository.findById(registrarUsuarioRequestDTO.getEstadoUsuarioId()).orElse(null)
        );

        usuarioRepository.save(usuarioDomainEntity);

        String registeredUsuarioId = usuarioRepository.findByCorreo(registrarUsuarioRequestDTO.getCorreo()).map(id -> id.toString()).orElse(null);

        if (registeredUsuarioId == null) {
            throw new IOException(); // Siempre debes especificar que la funciona puede arrojar un error
        }

        for(String rolId : registrarUsuarioRequestDTO.getRolId()){
            usuarioRolRepository.save(
                registeredUsuarioId , 
                rolId
            );
        }

        if(registrarUsuarioRequestDTO instanceof RegistrarEstudianteRequestDTO RegEst){
            EstudianteDomainEntity estudianteDomainEntity = EstudianteDomainEntity.create(
                registeredUsuarioId , 
                RegEst.getSemestre() , 
                RegEst.getCarrera() , 
                RegEst.getCodigoEstudiante()
            );
            
            estudianteRepository.save(estudianteDomainEntity);
            return "Usuario Estudiante registrado con extio.";
        }
        else{
            return "Error al intentar registrar al estudiante.";
        }
    }
}
